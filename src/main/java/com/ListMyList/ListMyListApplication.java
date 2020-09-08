package com.ListMyList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class ListMyListApplication{

	public static void main(String[] args) {
		SpringApplication.run(ListMyListApplication.class, args);

	}

	@Bean
	Validator validator() {
		return new LocalValidatorFactoryBean();
	}
}
