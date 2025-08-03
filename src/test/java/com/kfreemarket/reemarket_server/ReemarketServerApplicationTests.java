package com.kfreemarket.reemarket_server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles("test")
@SpringBootTest
@TestPropertySource(properties = {
		"jwt.secretKey=3488e49ce4419434d1ac6566e4841d210a9f3d58676f35188989e0b83dba26636a5fb138a636142697b4c59309b27d122784f144ab7efee9521a6b78fa879eae"
})
class ReemarketServerApplicationTests {

	@Test
	void contextLoads() {
	}

}
