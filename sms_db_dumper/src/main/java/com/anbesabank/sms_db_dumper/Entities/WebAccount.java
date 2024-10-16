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
//import java.util.Date;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Builder
//@Entity
//public class WebAccount {
//
//    @Column(name = "USER_ID", length = 30, nullable = false)
//    private String userId;
//
//    @Column(name = "FULL_NAME", length = 50)
//    private String fullName;
//
//    @Column(name = "CUSTOMER_ID", length = 15, nullable = false)
//    private String customerId;
//
//    @Column(name = "ACCOUNT_NUMBER", length = 11, nullable = false)
//    private String accountNumber;
//
//    @Column(name = "PHONE_NUMBER", length = 20)
//    private String phoneNumber;
//
//    @Column(name = "BRANCH", length = 30)
//    private String branch;
//
//    @Column(name = "CUSTOMER_BRANCH", length = 5, nullable = false)
//    private String customerBranch;
//
//    @Column(name = "DATE_CREATION")
//    private Date dateCreation;
//
//    @Column(name = "TRANSACTION_CATAGORY", length = 1)
//    private String transactionCategory;
//
//    @Column(name = "TRANSACTION_TYPE", length = 3)
//    private String transactionType;
//
//    @Id
//    @Column(name = "UNIQUE_KEY", length = 56)
//    private String uniqueKey;
//
//}
