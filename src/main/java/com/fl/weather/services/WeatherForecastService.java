package com.fl.weather.services;

import org.springframework.stereotype.Service;

import com.fl.weather.model.AverageWeatherForecast;


public interface WeatherForecastService {
	int DEFAULT_DAYS = 3;

	AverageWeatherForecast getDefaultAvgWeatherForecastByCity(String city);

	AverageWeatherForecast getAvgWeatherForecastForGivenDaysByCity(int days,String city);

}
