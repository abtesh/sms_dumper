package com.anbesabank.sms_db_dumper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SmsDbDumperApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsDbDumperApplication.class, args);
	}

}
