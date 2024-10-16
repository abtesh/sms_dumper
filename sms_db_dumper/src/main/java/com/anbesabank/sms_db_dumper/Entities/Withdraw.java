package com.anbesabank.sms_db_dumper.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Entity
@Table(name = "Withdr", schema = "anbesaprod")
public class Withdraw {
    @Id
    @Column(name = "UNIQUE_KEY", columnDefinition = "varchar2(54 CHAR)")
    private String  uniqueKey;

    @Column(name = "TRANSACTION_LOCATION", columnDefinition = "varchar2(106 CHAR)")
    private String transactionLocation;

    @Column(name = "ACCOUNT_NUMBER", columnDefinition = "varchar2(11 CHAR)")
    private String accountNumber;

    @Column(name = "AMOUNT", columnDefinition = "number(19,4)")
    private String amount;

    @Column(name = "CURRENT_BALANCE", columnDefinition = "number")
    private String currentBalance;

    @Column(name = "TRANSACTION_DATE", columnDefinition = "date")
    private Date transactionDate;

    @Column(name = "PHONE", columnDefinition = "varchar2(20 CHAR)")
    private String phone;

    @Column(name = "CHANNEL", columnDefinition = "char(10 CHAR)")
    private String channel;

    @Column(name = "TRANSACTION_CATAGORY", columnDefinition = "char(3 CHAR)")
    private String transactionCategory;

    @Column(name = "TRASACTION_TIME", columnDefinition = "varchar2(12 CHAR)")
    private String trnsactionTime;

    @Column(name = "TRANSACTION_TYPE", columnDefinition = "char(10 CHAR)")
    private String transactionType;

}


