package com.fl.weather.services;

import com.fl.weather.model.AverageWeatherForecast;

public interface WeatherForecastService {

	AverageWeatherForecast getAvgWeatherForecastByCity(String city);

}
