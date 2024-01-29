package com.maizeapp.maize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
@EnableScheduling
@EnableAutoConfiguration
@SpringBootApplication
public class MaizeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaizeappApplication.class, args);
	}

}
