package com.master.MCardChallenge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

class MCardChallengeCityFound1Row {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/connected?origin=Newark&destination=Boston",
				String.class)).contains("yes");
		
	}
}
