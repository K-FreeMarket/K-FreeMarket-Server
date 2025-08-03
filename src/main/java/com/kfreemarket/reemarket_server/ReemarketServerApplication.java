package com.kfreemarket.reemarket_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@PropertySources({
		@PropertySource("classpath:properties/env.properties") // env.properties 파일 소스 등록
})
public class ReemarketServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReemarketServerApplication.class, args);
	}

}
