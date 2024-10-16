package com.anbesabank.sms_db_dumper.Service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import com.anbesabank.sms_db_dumper.Entities.Salary;
import com.anbesabank.sms_db_dumper.Enums.RedisModelType;
import com.anbesabank.sms_db_dumper.RedisModel.RedisSalary;
import com.anbesabank.sms_db_dumper.Repositories.SalaryRepository;
import com.anbesabank.sms_db_dumper.Repositories.PostgresRepo.PostgresSalaryRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostgresSalaryService {

    private final SalaryRepository salaryRepository;
    private final PostgresSalaryRepository postgresSalaryRepository;
    private final RedisService redisService;

    public PostgresSalaryService(SalaryRepository salaryRepository, PostgresSalaryRepository postgresSalaryRepository, RedisService redisService) {
        this.salaryRepository = salaryRepository;
        this.postgresSalaryRepository = postgresSalaryRepository;
        this.redisService = redisService;
    }

    @Scheduled(fixedRate = 60000) // Changed to 10 seconds for better testing
    public void transferSalaries() {
        List<RedisSalary> redisSalaries = StreamSupport.stream(salaryRepository.findAll().spliterator(), false)
                .filter(Objects::nonNull) // Filter out null entries
                .collect(Collectors.toList());

        // Check if redisSalaries is empty
        if (redisSalaries.isEmpty()) {
            // Log or handle the empty case, and exit early
            System.out.println("No redis salaries found. Exiting transfer process.");
            return;
        }

        List<Salary> postgresSalaries = redisSalaries.stream()
                .map(this::convertToPostgresSalary)
                .collect(Collectors.toList());

        if (!postgresSalaries.isEmpty()) { // Only save if there are salaries to save
            postgresSalaryRepository.saveAll(postgresSalaries);
        }

        RedisSalary lastSalary = (RedisSalary) redisService.getLastInsertedRecord(RedisModelType.SALARY);
        deleteAllExceptLast(redisSalaries, lastSalary);
    }

    private Salary convertToPostgresSalary(RedisSalary redisSalary) {
        return Salary.builder()
                .accountNumber(redisSalary.getAccountNumber())
                .amount(redisSalary.getAmount())
                .currentBalance(redisSalary.getCurrentBalance())
                .transactionDate(redisSalary.getTransactionDate())
                .channel(redisSalary.getChannel())
                .transactionTime(redisSalary.getTransactionTime())
                .phone(redisSalary.getPhoneNumber())
                .transactionCategory(redisSalary.getTransactionCategory())
                .transactionType(redisSalary.getTransactionType())
                .transactionLocation(redisSalary.getTransactionLocation())
                .uniqueKey(redisSalary.getUniqueKey())
                .payrollMonth(redisSalary.getPayrollMonth())
                .reason(redisSalary.getReason())
                .transactionTimeStamp(redisSalary.getTransactionTimestamp())
                .build();
    }

    private void deleteAllExceptLast(List<RedisSalary> redisSalaries, RedisSalary lastSalary) {
        List<RedisSalary> salariesToDelete = new ArrayList<>();

        for (RedisSalary salary : redisSalaries) {
            if (!salary.getUniqueKey().equals(lastSalary.getUniqueKey())) {
                salariesToDelete.add(salary);
            }
        }

        // Delete all salaries that are not the last one
        salaryRepository.deleteAll(salariesToDelete);
    }
}