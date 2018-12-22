package com.fl.weather.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fl.weather.json.pojo.WeatherForecast;
import com.fl.weather.services.OpenWeatherMapService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenWeatherServiceTests {

	@Autowired
	private OpenWeatherMapService openWeatherService;

	@Test
	public void testGetOpenWetherForecastByCity() {
		ResponseEntity<WeatherForecast> response = openWeatherService.getWetherForecastByCity("pune");
		assertNotNull(response);
	}
}
