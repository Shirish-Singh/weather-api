package com.fl.weather.services.impl;

import org.springframework.stereotype.Service;

import com.fl.weather.model.AverageWeatherForecast;
import com.fl.weather.services.WeatherForecastService;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService {

	@Override
	public AverageWeatherForecast getDefaultAvgWeatherForecastByCity(String city) {
		AverageWeatherForecast averageWeatherForecast = new AverageWeatherForecast();
		averageWeatherForecast.setMaxTemp(12.4f);
		averageWeatherForecast.setMinTemp(3.2f);
		averageWeatherForecast.setPressure(2.5f);
		return averageWeatherForecast;
	}

	@Override
	public AverageWeatherForecast getAvgWeatherForecastForGivenDaysByCity(int days, String city) {
		AverageWeatherForecast averageWeatherForecast = new AverageWeatherForecast();
		averageWeatherForecast.setMaxTemp(5.4f);
		averageWeatherForecast.setMinTemp(2.2f);
		averageWeatherForecast.setPressure(6.5f);
		return averageWeatherForecast;
	}

}
