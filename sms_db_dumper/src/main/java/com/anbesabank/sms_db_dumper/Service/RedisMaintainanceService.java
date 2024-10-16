package com.anbesabank.sms_db_dumper.Service;

import com.anbesabank.sms_db_dumper.Enums.RedisModelType;
import com.anbesabank.sms_db_dumper.RedisModel.RedisDeposit;
import com.anbesabank.sms_db_dumper.Repositories.DepositRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class RedisMaintainanceService {
    private final DepositRepository depositRepository;
    private final RedisService redisService;

    public RedisMaintainanceService(DepositRepository depositRepository, RedisService redisService) {
        this.depositRepository = depositRepository;
        this.redisService = redisService;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void resetRedisAtMidnight() {
        // Check if Redis is empty
        RedisDeposit lastDeposit = (RedisDeposit) redisService.getLastInsertedRecord(RedisModelType.DEPOSIT);
        if (lastDeposit == null) {
            // Set a default value if Redis is empty
            RedisDeposit defaultDeposit = createDefaultDeposit();
            depositRepository.save(defaultDeposit);
        } else {
            // Clear Redis
            depositRepository.deleteAll();
            // Re-insert the last record back into Redis
            depositRepository.save(lastDeposit);
        }
    }

    private RedisDeposit createDefaultDeposit() {
        return RedisDeposit.builder()
                .uniqueKey("default")
                .transactionDate("1970-01-01")
                .trasactionTime("00:00:00")
                .transactionLocation("default")
                .accountNumber("default")
                .amount("0.00")
                .currentBalance("0.00")
                .phone("default")
                .channel("default")
                .transactionCategory("default")
                .transactionType("default")
                .build();
    }
}
