package com.fl.weather.services;

import org.springframework.http.ResponseEntity;

import com.fl.weather.json.pojo.WeatherForecast;

public interface OpenWeatherMapService {

	ResponseEntity<WeatherForecast> getWetherForecastByCity(String cityName);
}
