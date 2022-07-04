package com.in28minutes.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.microservices.currencyexchangeservice.resource.ExchangeValue;
import com.in28minutes.microservices.currencyexchangeservice.resource.ExchangeValueRepository;

@SpringBootApplication
public class CurrencyExchangeServiceApplicationMySql implements CommandLineRunner {

	@Autowired
	ExchangeValueRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplicationMySql.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		long count = repository.count();

		if (count == 0) {
			repository.save(new ExchangeValue(10001L, "USD", "INR", BigDecimal.valueOf(78)));
			repository.save(new ExchangeValue(10002L, "EUR", "INR", BigDecimal.valueOf(82)));
			repository.save(new ExchangeValue(10003L, "AUD", "INR", BigDecimal.valueOf(54)));
			repository.save(new ExchangeValue(10004L, "AED", "INR", BigDecimal.valueOf(21)));
			repository.save(new ExchangeValue(10005L, "SGD", "INR", BigDecimal.valueOf(56)));
			repository.save(new ExchangeValue(10006L, "CAD", "INR", BigDecimal.valueOf(61)));
		}
	}

}
