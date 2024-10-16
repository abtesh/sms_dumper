package com.anbesabank.sms_db_dumper.Controllers;

import com.anbesabank.sms_db_dumper.Enums.RedisModelType;
import com.anbesabank.sms_db_dumper.RedisModel.*;
import com.anbesabank.sms_db_dumper.Service.RedisService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/redis")
public class RedisController {
    private final RedisService redisService;

    public RedisController(RedisService redisService) {
        this.redisService = redisService;
    }
    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

    @PostMapping("/salary")
    public ResponseEntity<Void> salary(@RequestBody List<RedisSalary> salary) {
        redisService.saveSalary(salary);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Iterable<RedisSalary>> allSalaries() {
        return ResponseEntity.ok(redisService.getAllSalaries());
    }

    @PostMapping("/deposit")
    public ResponseEntity<Void> Deposit(@RequestBody List<RedisDeposit> deposits) {
        logger.info("Received deposits: {}", deposits); // Log the incoming deposits
        redisService.saveDeposits(deposits);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/deposit")
    public ResponseEntity<Iterable<RedisDeposit>> allDeposits() {
        return ResponseEntity.ok(redisService.getAllDeposits());
    }

    @PostMapping("/depositNonca")
    public ResponseEntity<Void> DepositNonca(@RequestBody List<RedisDepositNonca> depositNoncas) {
        redisService.saveDepositsNonca(depositNoncas);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/fxDeposit")
    public ResponseEntity<Void> FxDeposit(@RequestBody List<RedisFxDeposit> fxDeposits) {
        redisService.saveFxDeposit(fxDeposits);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/newAccount")
    public ResponseEntity<Void> NewAccount(@RequestBody List<RedisNewAccount> newAccounts) {
        redisService.saveNewAccount(newAccounts);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/webAccount")
    public ResponseEntity<Void> WebAccount(@RequestBody List<RedisWebAccount> webAccounts) {
        redisService.saveWebAccount(webAccounts);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Void> Withdraw(@RequestBody List<RedisWithdraw> withdraws) {
        redisService.saveWithdraw(withdraws);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/withdraw")
    public ResponseEntity<Iterable<RedisWithdraw>> allWithdraws() {
        return ResponseEntity.ok(redisService.getAllWithdraws());
    }

    @GetMapping("/last")
    public ResponseEntity<Object> getLast(@RequestParam RedisModelType key) {
        Object lastRecord = redisService.getLastInsertedRecord(key);

        if(lastRecord == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(lastRecord);
    }
}

