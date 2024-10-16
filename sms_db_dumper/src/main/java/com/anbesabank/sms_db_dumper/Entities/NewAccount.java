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
//public class NewAccount {
//
//    @Column(name = "NAME", length = 30)
//    private String name;
//
//    @Column(name = "BRANCH", length = 30)
//    private String branch;
//
//    @Column(name = "ACCOUNT_NO", length = 11, nullable = false)
//    private String accountNo;
//
//    @Column(name = "CUST_ID", length = 15)
//    private String custId;
//
//    @Column(name = "PHONE", length = 20)
//    private String phone;
//
//    @Column(name = "CREATION_DATE")
//    private Date creationDate;
//
//    @Column(name = "TRANSACTION_CATAGORY", length = 1)
//    private String transactionCategory;
//
//    @Column(name = "TRANSACTION_TYPE", length = 6)
//    private String transactionType;
//
//    @Id
//    @Column(name = "UNIQUE_KEY", length = 31)
//    private String uniqueKey;
//}
