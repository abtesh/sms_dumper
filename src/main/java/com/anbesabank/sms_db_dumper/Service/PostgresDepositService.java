package com.anbesabank.sms_db_dumper.Service;

import com.anbesabank.sms_db_dumper.Entities.Deposit;
import com.anbesabank.sms_db_dumper.Enums.RedisModelType;
import com.anbesabank.sms_db_dumper.RedisModel.RedisDeposit;
import com.anbesabank.sms_db_dumper.Repositories.DepositRepository;
import com.anbesabank.sms_db_dumper.Repositories.PostgresRepo.PostgresDepositRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostgresDepositService {

    private final DepositRepository depositRepository;
    private final PostgresDepositRepository postgresDepositRepository;
    private final RedisService redisService;

    public PostgresDepositService(DepositRepository depositRepository, PostgresDepositRepository postgresDepositRepository, RedisService redisService) {
        this.depositRepository = depositRepository;
        this.postgresDepositRepository = postgresDepositRepository;
        this.redisService = redisService;
    }

    @Scheduled(fixedRate = 10000) // Changed to 10 seconds for better testing
    public void transferDeposits() {
        List<RedisDeposit> redisDeposits = StreamSupport.stream(depositRepository.findAll().spliterator(), false)
                .filter(Objects::nonNull) // Filter out null entries
                .limit(50) // Limit to 50 records
                .collect(Collectors.toList());

        // Check if redisDeposits is empty
        if (redisDeposits.isEmpty()) {
            // Log or handle the empty case, and exit early
            System.out.println("No redis deposits found. Exiting transfer process.");
            return;
        }

        List<Deposit> postgresDeposits = redisDeposits.stream()
                .map(this::convertToPostgresDeposit)
                .collect(Collectors.toList());

        if (!postgresDeposits.isEmpty()) { // Only save if there are deposits to save
            postgresDeposits = postgresDepositRepository.saveAll(postgresDeposits);
            depositRepository.deleteAll(redisDeposits);
        }

        RedisDeposit lastDeposit = (RedisDeposit) redisService.getLastInsertedRecord(RedisModelType.DEPOSIT);
        deleteAllExceptLast(redisDeposits, lastDeposit);
    }

    private Deposit convertToPostgresDeposit(RedisDeposit redisDeposit) {
        return Deposit.builder()
                .accountNumber(redisDeposit.getAccountNumber())
                .amount(redisDeposit.getAmount())
                .currentBalance(redisDeposit.getCurrentBalance())
                .transactionDate(redisDeposit.getTransactionDate())
                .channel(redisDeposit.getChannel())
                .trnsactionTime(redisDeposit.getTransactionTime())
                .phone(redisDeposit.getPhone())
                .transactionCategory(redisDeposit.getTransactionCategory())
                .transactionType(redisDeposit.getTransactionType())
                .transactionLocation(redisDeposit.getTransactionLocation())
                .uniqueKey(redisDeposit.getUniqueKey())
                .build();
    }

    private void deleteAllExceptLast(List<RedisDeposit> redisDeposits, RedisDeposit lastDeposit) {
        List<RedisDeposit> depositsToDelete = new ArrayList<>();

        for (RedisDeposit deposit : redisDeposits) {
            if (!deposit.getUniqueKey().equals(lastDeposit.getUniqueKey())) {
                depositsToDelete.add(deposit);
            }
        }

        // Delete all deposits that are not the last one
        depositRepository.deleteAll(depositsToDelete);
    }
}
