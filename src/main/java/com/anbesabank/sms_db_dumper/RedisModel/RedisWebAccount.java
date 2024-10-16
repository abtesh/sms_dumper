package com.anbesabank.sms_db_dumper.RedisModel;

import com.anbesabank.sms_db_dumper.Service.TimestampedEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@RedisHash("WebAccount")
public class RedisWebAccount {
    private String userId;

    private String fullName;

    private String customerId;

    private String accountNumber;

    private String phoneNumber;

    private String branch;

    private String customerBranch;

    private Date dateCreation;

    private String transactionCategory;

    private String transactionType;

    @Id
    private String uniqueKey;


}
