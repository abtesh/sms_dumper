//package com.anbesabank.sms_db_dumper.Entities;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.math.BigDecimal;
//import java.util.Date;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Builder
//@Entity
//public class Salary {
//
//    @Column(name = "TRANSACTION_LOCATION", length = 30)
//    private String transactionLocation;
//
//    @Column(name = "ACCOUNT_NUMBER", length = 11)
//    private String accountNumber;
//
//    @Column(name = "AMOUNT", precision = 19, scale = 4)
//    private BigDecimal amount;
//
//    @Column(name = "CURRENT_BALANCE", precision = 19, scale = 4)
//    private BigDecimal currentBalance;
//
//    @Column(name = "PAYROLL_MONTH", length = 10)
//    private String payrollMonth;
//
//    @Column(name = "REASON", length = 40)
//    private String reason;
//
//    @Column(name = "TRANSACTION_TIMESTAMP")
//    private Date transactionTimestamp;
//
//    @Column(name = "PHONE_NUMBER", length = 20)
//    private String phoneNumber;
//
//    @Id
//    @Column(name = "UNIQUE_KEY", length = 34)
//    private String uniqueKey;
//
//    @Column(name = "CHANNEL", length = 3)
//    private String channel;
//
//    @Column(name = "TXN_DATE")
//    private Date txnDate;
//
//    @Column(name = "TXN_TIME", length = 12)
//    private String txnTime;
//
//    @Column(name = "TRANSACTION_CATAGORY", length = 2)
//    private String transactionCategory;
//
//    @Column(name = "TRANSACTION_TYPE", length = 6)
//    private String transactionType;
//}
