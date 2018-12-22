package com.fl.weather;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fl.weather.constants.API;
import com.fl.weather.constants.SecuredConstants;
import com.fl.weather.json.pojo.WeatherForecast;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class WeatherServiceApplicationIntegrationTests extends BaseIntegrationTest {

	private final String DATA_ENDPOINT = BASE_URL + "data";

	@Test
	public void testWeatherServiceViaGetEndPoint() {
		String cityNameParam = "?city=pune";
		ResponseEntity<String> response = getRestTemplate().exchange(createURLWithPort(DATA_ENDPOINT + cityNameParam),
				HttpMethod.GET, getHttpEntity(), String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode().OK);
	}

	@Test
	public void testOpenWeatherServiceViaGetEndPoint() {
		// Prepare query parameters
		Map<String, String> params = new HashMap<String, String>();
		params.put("city", "pune");
		params.put("appId", SecuredConstants.APP_ID);
		params.put("unit", "metric");

		// Request Weather forecast data
		ResponseEntity<WeatherForecast> response = getRestTemplate().exchange(API.OPEN_WEATHER, HttpMethod.GET,
				null, WeatherForecast.class, params);

		assertEquals(HttpStatus.OK, response.getStatusCode().OK);
	}
}
