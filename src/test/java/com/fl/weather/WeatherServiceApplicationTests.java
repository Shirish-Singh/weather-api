package com.fl.weather;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fl.weather.model.AverageWeatherForecast;
import com.fl.weather.services.WeatherForecastService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherServiceApplicationTests {

	@Autowired
	private WeatherForecastService weatherForecastService;

	@Test
	public void testGetDefaultAvgWeatherForecastByCity() {
		AverageWeatherForecast averageWeatherForecast = weatherForecastService
				.getDefaultAvgWeatherForecastByCity("pune");
		assertEquals(new Float(12.44f), averageWeatherForecast.getMaxTemp());
	}

}
