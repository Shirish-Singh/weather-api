package com.fl.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fl.weather.api.WeatherServiceApi;
import com.fl.weather.model.AverageWeatherForecast;
import com.fl.weather.services.WeatherForecastService;

@RestController
public class WeatherServiceController implements WeatherServiceApi {

	@Autowired
	private WeatherForecastService weatherForecastService;

	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public AverageWeatherForecast getAverage(@RequestParam(value = "city", required = true) String cityName) {
		return weatherForecastService.getAvgWeatherForecastByCity(cityName);
	}
}
