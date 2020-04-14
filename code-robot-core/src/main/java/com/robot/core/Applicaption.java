package com.robot.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.robot"})
public class Applicaption {

	public static void main(String[] args) {
		SpringApplication.run(Applicaption.class, args);
	}
}
