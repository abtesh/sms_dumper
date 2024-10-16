package com.anbesabank.sms_db_dumper.Entities;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Entity
@Table(name = "Withdrawal", schema = "sms_user")
public class Withdraw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String transactionDate;

    @Column(name = "PHONE", columnDefinition = "varchar2(20 CHAR)")
    private String phone;

    @Column(name = "CHANNEL", columnDefinition = "char(3 CHAR)")
    private String channel;

    @Column(name = "TRANSACTION_CATAGORY", columnDefinition = "char(1 CHAR)")
    private String transactionCategory;

    @Column(name = "TRASACTION_TIME", columnDefinition = "varchar2(12 CHAR)")
    private String trnsactionTime;

    @Column(name = "TRANSACTION_TYPE", columnDefinition = "char(10 CHAR)")
    private String transactionType;

}




//@Column(name = "TRANSACTION_LOCATION", length = 103)
//private String transactionLocation;
//
//@Column(name = "ACCOUNT_NUMBER", length = 11)
//private String accountNumber;
//
//@Column(name = "AMOUNT", precision = 19, scale = 4)
//private String amount;
//
//@Column(name = "CURRENT_BALANCE")
//private String currentBalance;
//
//@Column(name = "TRANSACTION_DATE")
//private String transactionDate;
//
//@Column(name = "PHONE", length = 20)
//private String phone;
//
//@Id
//@Column(name = "UNIQUE_KEY", length = 54)
//private String uniqueKey;
//
//@Column(name = "CHANNEL", length = 3)
//private String channel;
//
//@Column(name = "TRANSACTION_CATAGORY", length = 3)
//private String transactionCategory;
//
//@Column(name = "TRASACTION_TIME", length = 12)
//private String trasactionTime;
//
//@Column(name = "TRANSACTION_TYPE", length = 10)
//private String transactionType;