package com.anbesabank.sms_db_dumper.Service;

import com.anbesabank.sms_db_dumper.Entities.Withdraw;
import com.anbesabank.sms_db_dumper.Enums.RedisModelType;
import com.anbesabank.sms_db_dumper.RedisModel.RedisWithdraw;
import com.anbesabank.sms_db_dumper.Repositories.PostgresRepo.PostgresWithdrawRepository;
import com.anbesabank.sms_db_dumper.Repositories.WithdrawRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostgresWithdrawService {
    private final WithdrawRepository withdrawRepository;
    private final PostgresWithdrawRepository postgresWithdrawRepository;
    private final RedisService redisService;

    public PostgresWithdrawService(WithdrawRepository withdrawRepository, PostgresWithdrawRepository postgresWithdrawRepository, RedisService redisService) {
        this.withdrawRepository = withdrawRepository;
        this.postgresWithdrawRepository = postgresWithdrawRepository;
        this.redisService = redisService;
    }

    @Scheduled(fixedRate = 10000) // Adjusted to 10 seconds for testing
    public void transferWithdraws() {
        List<RedisWithdraw> redisWithdraws = StreamSupport.stream(withdrawRepository.findAll().spliterator(), false)
                .filter(Objects::nonNull) // Filter out null entries
                .collect(Collectors.toList());

        // Check if redisWithdraws is empty
        if (redisWithdraws.isEmpty()) {
            System.out.println("No redis withdrawals found. Exiting transfer process.");
            return;
        }

        // Convert RedisWithdraw to Withdraw
        List<Withdraw> postgresWithdraws = redisWithdraws.stream()
                .map(this::convertToPostgresWithdraw)
                .collect(Collectors.toList());

        // Save all PostgreSQL withdrawals
        if (!postgresWithdraws.isEmpty()) {
            postgresWithdrawRepository.saveAll(postgresWithdraws);
        }

        // Get the last RedisWithdraw record
        RedisWithdraw lastWithdraw = (RedisWithdraw) redisService.getLastInsertedRecord(RedisModelType.WITHDRAW);
        deleteAllExceptLast(redisWithdraws, lastWithdraw);
    }

    private Withdraw convertToPostgresWithdraw(RedisWithdraw redisWithdraw) {
        return Withdraw.builder()
                .transactionLocation(redisWithdraw.getTransactionLocation())
                .accountNumber(redisWithdraw.getAccountNumber())
                .amount(redisWithdraw.getAmount())
                .currentBalance(redisWithdraw.getCurrentBalance())
                .transactionDate(redisWithdraw.getTransactionDate())
                .channel(redisWithdraw.getChannel())
                .trnsactionTime(redisWithdraw.getTransactionTime())
                .phone(redisWithdraw.getPhone())
                .transactionCategory(redisWithdraw.getTransactionCategory())
                .transactionType(redisWithdraw.getTransactionType())
                .uniqueKey(redisWithdraw.getUniqueKey())
                .build();
    }

    private void deleteAllExceptLast(List<RedisWithdraw> redisWithdraws, RedisWithdraw lastWithdraw) {
        List<RedisWithdraw> withdrawalsToDelete = new ArrayList<>();

        for (RedisWithdraw withdraw : redisWithdraws) {
            if (!withdraw.getUniqueKey().equals(lastWithdraw.getUniqueKey())) {
                withdrawalsToDelete.add(withdraw);
            }
        }

        // Delete all withdrawals that are not the last one
        withdrawRepository.deleteAll(withdrawalsToDelete);
    }
}
