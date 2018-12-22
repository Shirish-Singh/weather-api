package com.fl.weather.services;

import static org.junit.Assert.assertNotNull;
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
	public void testAverageWeatherForecastByCity() {
		AverageWeatherForecast averageWeatherForecast = weatherForecastService.getAvgWeatherForecastByCity("pune");
		assertNotNull(averageWeatherForecast.getAvgDailyTemp());
		assertNotNull(averageWeatherForecast.getAvgNightlyTemp());
		assertNotNull(averageWeatherForecast.getAvgPressure());
	}
}
