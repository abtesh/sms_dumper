package com.anbesabank.sms_db_dumper.Service;

import com.anbesabank.sms_db_dumper.Entities.Salary;
import com.anbesabank.sms_db_dumper.Enums.RedisModelType;
import com.anbesabank.sms_db_dumper.RedisModel.*;
import com.anbesabank.sms_db_dumper.Repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class RedisService {
    private final SalaryRepository salaryRepository;
    private final DepositRepository depositRepository;
    private final DepositNoncaRepository depositNoncaRepository;
    private final FxDepositRepository fxDepositRepository;
    private final NewAccountRepository newAccountRepository;
    private final WebAccountRepository webAccountRepository;
    private final WithdrawRepository withdrawRepository;

    public RedisService(SalaryRepository salaryRepository, DepositRepository depositRepository, DepositNoncaRepository depositNoncaRepository, FxDepositRepository fxDepositRepository, NewAccountRepository newAccountRepository, WebAccountRepository webAccountRepository, WithdrawRepository withdrawRepository) {
        this.salaryRepository = salaryRepository;
        this.depositRepository = depositRepository;
        this.depositNoncaRepository = depositNoncaRepository;
        this.fxDepositRepository = fxDepositRepository;
        this.newAccountRepository = newAccountRepository;
        this.webAccountRepository = webAccountRepository;
        this.withdrawRepository = withdrawRepository;
    }


    public void saveSalary(List<RedisSalary> salary) {
        salaryRepository.saveAll(salary);
    }

    public Iterable<RedisSalary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    public Iterable<RedisDeposit> getAllDeposits() {
        return depositRepository.findAll();
    }

    public Iterable<RedisWithdraw> getAllWithdraws() {
        return withdrawRepository.findAll();
    }

    public void saveDeposits(List<RedisDeposit> deposits) {
        depositRepository.saveAll(deposits);
    }

    public void saveDepositsNonca(List<RedisDepositNonca> depositNoncas) {
        depositNoncaRepository.saveAll(depositNoncas);
    }

    public void saveFxDeposit(List<RedisFxDeposit> fxDeposits) {
        fxDepositRepository.saveAll(fxDeposits);
    }

    public void saveNewAccount(List<RedisNewAccount> newAccounts) {
        newAccountRepository.saveAll(newAccounts);
    }

    public void saveWebAccount(List<RedisWebAccount> webAccounts) {
        webAccountRepository.saveAll(webAccounts);
    }

    public void saveWithdraw(List<RedisWithdraw> withdraws) {
        withdrawRepository.saveAll(withdraws);
    }

    public Object getLastInsertedRecord(RedisModelType redisModelType) {
        Object lastRecord;
        switch (redisModelType) {
            case SALARY:
                lastRecord = findLast(salaryRepository.findAll());
                return lastRecord != null ? lastRecord : createDefaultSalary();
            case DEPOSIT:
                lastRecord = findLast(depositRepository.findAll());
                return lastRecord != null ? lastRecord : createDefaultDeposit();
            case DEPOSITNONCA:
                lastRecord = findLast(depositNoncaRepository.findAll());
                return lastRecord != null ? lastRecord : createDefaultDepositNonca();
            case FXDEPOSIT:
                lastRecord = findLast(fxDepositRepository.findAll());
                return lastRecord != null ? lastRecord : createDefaultFxDeposit();
            case WITHDRAW:
                lastRecord = findLast(withdrawRepository.findAll());
                return lastRecord != null ? lastRecord : createDefaultWithdraw();
            default:
                return null;
        }
    }

    public  <T extends TimestampedEntity> T findLast(Iterable<T> entities) {
        List<T> entityList = new ArrayList<>();

        for (T entity : entities) {
            if (entity == null) {
                System.out.println("Found null entity");
            } else {
                entityList.add(entity);
                System.out.println("Entity added: " + entity);
            }
        }

        if (entityList.isEmpty()) {
            System.out.println("No entities found");
            return null;
        }

        entityList.sort(Comparator.comparing(TimestampedEntity::getTransactionDate, Comparator.nullsLast(Comparator.naturalOrder()))
                .thenComparing(TimestampedEntity::getTransactionTime, Comparator.nullsLast(Comparator.naturalOrder()))
                .reversed());

        return entityList.get(0);
    }

    private Salary createDefaultSalary() {
        return new Salary(
                "default",                   // uniqueKey
                "default",                   // transactionLocation
                "00000000000",               // accountNumber
                "default",                   // payrollMonth
                "default",                   // reason
                "0.00",                     // amount
                "0.00",                     // currentBalance
                new Date("11-OCT-24"),                // transactionDate (1970-01-01 in milliseconds)
                new Date("11-OCT-24"),                // transactionTimeStamp (1970-01-01)
                "0900000000",               // phone
                "default",                  // channel
                "default",                  // transactionCategory
                "00:00:00",                 // transactionTime
                "default"                   // transactionType
        );
    }

    private RedisDeposit createDefaultDeposit() {
        return new RedisDeposit(
                "default",                   // transactionLocation
                "0000000000",               // accountNumber
                "0.00",                     // amount
                "0.00",                     // currentBalance
                "1970-01-11 00:00:00",                // transactionDate (1970-01-01 in milliseconds)
                "0900000000",               // phone
                "default",                  // uniqueKey
                "default",                  // channel
                "default",                  // transactionCategory
                "00:00:00",                 // transactionTime
                "default"                   // transactionType
        );
    }

    private RedisDepositNonca createDefaultDepositNonca() {
        return RedisDepositNonca.builder()
                .uniqueKey("default")
                .transactionDate(new Date("1970-01-01"))
                .transactionTime("00:00:00")
                .amount("0.00")
                .build();
    }

    private RedisFxDeposit createDefaultFxDeposit() {
        return RedisFxDeposit.builder()
                .uniqueKey("default")
                .transactionDate(new Date("1970-01-01"))
                .transactionTime("00:00:00")
                .amount("0.00")
                .build();
    }

    private RedisWithdraw createDefaultWithdraw() {
        return new RedisWithdraw(
                "default",                   // transactionLocation
                "0000000000",               // accountNumber
                "0.00",                     // amount
                "0.00",                     // currentBalance
                "1970-01-11 00:00:00",                // transactionDate (1970-01-01 in milliseconds)
                "0900000000",               // phone
                "default",                  // uniqueKey
                "default",                  // channel
                "default",                  // transactionCategory
                "00:00:00",                 // transactionTime
                "default"                   // transactionType
        );
    }
}
