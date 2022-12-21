package com.example.Api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

//@ComponentScan({"com.delivery.request"})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableScheduling
public class ApiApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date date = new Date(System.currentTimeMillis());
		System.out.println("Launch Time "+ format.format(date));
		
	}
}
