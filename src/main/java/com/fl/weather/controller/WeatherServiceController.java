package com.fl.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fl.weather.services.WeatherForecastService;

@RestController
public class WeatherServiceController {

	@Autowired
	private WeatherForecastService weatherForecastService;
	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public Object getAverage(@RequestParam(value = "city", required = true) String cityName) {
		return "Ok";
	}
}
