package com.kfreemarket.reemarket_server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles("test")
@SpringBootTest
@TestPropertySource("classpath:properties/env.properties")
class ReemarketServerApplicationTests {

	@Test
	void contextLoads() {
	}

}
