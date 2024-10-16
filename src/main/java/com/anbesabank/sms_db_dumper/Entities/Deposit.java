package com.anbesabank.sms_db_dumper.Entities;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Deposit", schema = "anbesatest2")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UNIQUE_KEY", columnDefinition = "varchar2(54 CHAR)")
    private String uniqueKey;

    @Column(name = "TRANSACTION_LOCATION", columnDefinition = "varchar2(106 CHAR)")
    private String transactionLocation;

    @Column(name = "ACCOUNT_NUMBER", columnDefinition = "varchar2(11 CHAR)")
    private String accountNumber;

    @Column(name = "AMOUNT", columnDefinition = "varchar2(49 CHAR)")
    private String amount;

    @Column(name = "CURRENT_BALANCE", columnDefinition = "number")
    private String currentBalance;

    @Column(name = "TRANSACTION_DATE", columnDefinition = "date")
    private String transactionDate;

    @Column(name = "PHONE", columnDefinition = "varchar2(20 CHAR)")
    private String phone;

    @Column(name = "CHANNEL", columnDefinition = "char(47 CHAR)")
    private String channel;

    @Column(name = "TRANSACTION_CATAGORY", columnDefinition = "char(1 CHAR)")
    private String transactionCategory;

    @Column(name = "TRASACTION_TIME", columnDefinition = "varchar2(12 CHAR)")
    private String trnsactionTime;

    @Column(name = "TRANSACTION_TYPE", columnDefinition = "char(10 CHAR)")
    private String transactionType;

}






//    @Id
//    @Column(name = "UNIQUE_KEY", length = 54)
//    private String uniqueKey;
//
//    @Column(name = "TRANSACTION_LOCATION", length = 106) // Updated length
//    private String transactionLocation;
//
//    @Column(name = "ACCOUNT_NUMBER", length = 11)
//    private String accountNumber;
//
//
//    @Column(name = "AMOUNT", precision = 19, scale = 4) // Use BigDecimal for monetary values
//    private String amount;
//
//
//    @Column(name = "CURRENT_BALANCE", precision = 19, scale = 4) // Use BigDecimal
//    private String currentBalance;
//
//
//    @Column(name = "TRANSACTION_DATE")
//    private String transactionDate;
//
//
//    @Column(name = "PHONE", length = 20)
//    private String phone;
//
//    @Column(name = "CHANNEL", length = 47) // Adjust length as needed
//    private String channel;
//
//
//    @Column(name = "TRANSACTION_CATAGORY", length = 1) // Adjust based on actual usage
//    private String transactionCategory;
//
//
//    @Column(name = "TRASACTION_TIME", length = 12)
//    private String trasactionTime;
//
//
//    @Column(name = "TRANSACTION_TYPE", length = 10)
//    private String transactionType;