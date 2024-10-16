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
@RedisHash("DepositNonca")
public class RedisDepositNonca implements TimestampedEntity {
    private Long idNum;

    private String transactionLocation;

    private String accountNumber;

    private String amount;

    private BigDecimal currentBalance;

    private String transactionDate;

    private String phone;

    @Id
    private String uniqueKey;

    private String channel;

    private String transactionCategory;

    private String transactionTime;

    private String transactionType;


    @Override
    public String getTransactionDate() {
        return transactionDate;
    }

    @Override
    @JsonIgnore
    public String getTransactionTime() {
        return transactionTime;
    }
}
