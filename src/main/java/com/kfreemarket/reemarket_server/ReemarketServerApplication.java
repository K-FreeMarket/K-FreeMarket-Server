package com.kfreemarket.reemarket_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ReemarketServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReemarketServerApplication.class, args);
	}

}
