package com.nitin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.nitin.demo.controller.RandomNumberSortingController;

@SpringBootApplication
public class RandomNumberSortingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomNumberSortingApplication.class, args);
	}
	
}
