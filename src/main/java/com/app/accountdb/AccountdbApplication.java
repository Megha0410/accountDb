package com.app.accountdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.app.accountdb.entity")
@EnableJpaRepositories(basePackages= {"com.app.accountdb.repository"})
public class AccountdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountdbApplication.class, args);
	}

}
