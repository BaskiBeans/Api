package com.example.Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

//@ComponentScan({"com.delivery.request"})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

	System.out.println("gvvd");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date date = new Date(System.currentTimeMillis());
		System.out.println("An error occured"+ format.format(date));
	}

}
