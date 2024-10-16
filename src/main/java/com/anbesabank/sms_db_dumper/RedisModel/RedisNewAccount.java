package com.anbesabank.sms_db_dumper.RedisModel;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@RedisHash("NewAccount")
public class RedisNewAccount {
    private String name;

    private String branch;

    private String accountNo;

    private String custId;

    private String phone;

    private Date creationDate;

    private String transactionCategory;

    private String transactionType;

    @Id
    private String uniqueKey;
}
