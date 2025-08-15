package com.kfreemarket.reemarket_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableJpaAuditing
@SpringBootApplication
@PropertySources({
		@PropertySource(value = "classpath:properties/env.properties", ignoreResourceNotFound = true)
})
public class ReemarketServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReemarketServerApplication.class, args);
	}

}
