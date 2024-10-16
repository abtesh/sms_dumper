//package com.anbesabank.sms_db_dumper.Entities;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
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
//@Entity
//@Builder
//@Table
//public class DepositNonca {
//
//    @Column(name = "ID_NUM")
//    private Long idNum;
//
//    @Column(name = "TRANSACTION_LOCATION", length = 30)
//    private String transactionLocation;
//
//    @Column(name = "ACCOUNT_NUMBER", length = 11)
//    private String accountNumber;
//
//    @Column(name = "AMOUNT", length = 40)
//    private String amount;
//
//    @Column(name = "CURRENT_BALANCE", precision = 19, scale = 4)
//    private BigDecimal currentBalance;
//
//    @Column(name = "TRANSACTION_DATE")
//    private Date transactionDate;
//
//    @Column(name = "PHONE", length = 20)
//    private String phone;
//
//    @Id
//    @Column(name = "UNIQUE_KEY", length = 54)
//    private String uniqueKey;
//
//    @Column(name = "CHANNEL", length = 40)
//    private String channel;
//
//    @Column(name = "TRANSACTION_CATAGORY", length = 3)
//    private String transactionCategory;
//
//    @Column(name = "TRASACTION_TIME", length = 12)
//    private String transactionTime;
//
//    @Column(name = "TRANSACTION_TYPE", length = 6)
//    private String transactionType;
//}
