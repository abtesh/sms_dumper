package com.anbesabank.sms_db_dumper.RedisModel;

import com.anbesabank.sms_db_dumper.Service.TimestampedEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.math.BigDecimal;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@RedisHash("Salary")
public class RedisSalary implements TimestampedEntity {

    private String transactionLocation;

    private String accountNumber;

    private String amount;

    private String currentBalance;

    private String payrollMonth;

    private String reason;

    private Date transactionTimestamp;

    private String phoneNumber;

    @Id
    private String uniqueKey;

    private String channel;

    private Date txnDate;

    private String txnTime;

    private String transactionCategory;

    private String transactionType;

    @Override
    public Date getTransactionDate() {
        return txnDate;
    }

    @Override
    @JsonIgnore
    public String getTransactionTime() {
        return txnTime;
    }
}
