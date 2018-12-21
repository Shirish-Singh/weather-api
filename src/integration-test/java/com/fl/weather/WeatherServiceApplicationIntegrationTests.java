package com.fl.weather;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.assertEquals;

public class WeatherServiceApplicationIntegrationTests extends BaseIntegrationTest {

	private final String DATA_ENDPOINT = BASE_URL + "data";

	@Test
	public void test_given_city_name_then_get_average_data() {
		String cityNameParam = "?city=pune";
		ResponseEntity<String> response = getRestTemplate().exchange(createURLWithPort(DATA_ENDPOINT + cityNameParam),
				HttpMethod.GET, getHttpEntity(), String.class);

		final String expected = "Ok";
		assertEquals(expected, response.getBody());
	}
}
