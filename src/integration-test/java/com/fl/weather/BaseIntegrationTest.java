package com.fl.weather;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseIntegrationTest {

	protected static final String BASE_URL = "/weather-service/";

	@LocalServerPort
	private int port;

	private TestRestTemplate restTemplate;
	private HttpEntity<String> entity;

	BaseIntegrationTest() {
		entity = new HttpEntity<String>(null, new HttpHeaders());
		restTemplate = new TestRestTemplate();
	}

	public TestRestTemplate getRestTemplate() {
		return restTemplate;
	}

	public HttpEntity<String> getHttpEntity() {
		return entity;
	}

	protected String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}
