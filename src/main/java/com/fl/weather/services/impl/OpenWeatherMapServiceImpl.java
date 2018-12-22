package com.fl.weather.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fl.weather.constants.API;
import com.fl.weather.constants.SecuredConstants;
import com.fl.weather.json.pojo.WeatherForecast;
import com.fl.weather.services.OpenWeatherMapService;

@Service
public class OpenWeatherMapServiceImpl implements OpenWeatherMapService {

	private Logger logging = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<WeatherForecast> getWetherForecastByCity(String cityName) {
		logging.log(Level.INFO, " preparing data for calling open weather api");
		// Prepare query parameters
		Map<String, String> params = new HashMap<String, String>();
		params.put("city", cityName);
		params.put("appId", SecuredConstants.APP_ID);
		params.put("unit", "metric");
		
		//Request Weather forecast data
		ResponseEntity<WeatherForecast> response = restTemplate.exchange(API.OPEN_WEATHER, HttpMethod.GET, null,
				WeatherForecast.class, params);
		return response;
	}

}
