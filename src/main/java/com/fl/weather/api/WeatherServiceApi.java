package com.fl.weather.api;

import com.fl.weather.model.AverageWeatherForecast;

public interface WeatherServiceApi {

	public AverageWeatherForecast getAverage(String cityName);
}
