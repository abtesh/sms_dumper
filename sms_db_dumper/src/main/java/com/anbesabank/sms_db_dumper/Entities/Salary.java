package com.anbesabank.sms_db_dumper.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "salary", schema = "anbesaprod")
public class Salary {

    @Id
    @Column(name = "UNIQUE_KEY", columnDefinition = "varchar2(34 CHAR)")
    private String uniqueKey;
    @Column(name = "TRANSACTION_LOCATION", columnDefinition = "CHAR(30 CHAR)")
    private String transactionLocation;

    @Column(name = "ACCOUNT_NUMBER", columnDefinition = "char(11 CHAR)")
    private String accountNumber;

    @Column(name = "PAYROLL_MONTH", columnDefinition = "varchar2(10 CHAR)")
    private String payrollMonth;

    @Column(name = "REASON", columnDefinition = "varchar2(40 CHAR)")
    private String reason;

    @Column(name = "AMOUNT", columnDefinition = "number(19,4)")
    private String amount;

    @Column(name = "CURRENT_BALANCE", columnDefinition = "number")
    private String currentBalance;

    @Column(name = "TXN_DATE", columnDefinition = "date")
    private Date transactionDate;

    @Column(name = "TRANSACTION_TIMESTAMP", columnDefinition = "date")
    private Date transactionTimeStamp;

    @Column(name = "PHONE_NUMBER", columnDefinition = "char(20 CHAR)")
    private String phone;

    @Column(name = "CHANNEL", columnDefinition = "char(3 CHAR)")
    private String channel;

    @Column(name = "TRANSACTION_CATAGORY", columnDefinition = "char(1 CHAR)")
    private String transactionCategory;

    @Column(name = "TXN_TIME", columnDefinition = "char(12 CHAR)")
    private String transactionTime;

    @Column(name = "TRANSACTION_TYPE", columnDefinition = "char(6 CHAR)")
    private String transactionType;
}
