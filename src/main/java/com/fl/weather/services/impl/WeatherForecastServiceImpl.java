package com.fl.weather.services.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fl.weather.constants.Config;
import com.fl.weather.json.pojo.WeatherEntry;
import com.fl.weather.json.pojo.WeatherForecast;
import com.fl.weather.model.AverageWeatherForecast;
import com.fl.weather.services.OpenWeatherMapService;
import com.fl.weather.services.WeatherForecastService;
import com.fl.weather.utils.ForecastDateTimeUtil;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService {

	private Logger logging = Logger.getLogger(this.getClass().getName());

	@Autowired
	private OpenWeatherMapService openWeatherMapService;

	@Override
	public AverageWeatherForecast getAvgWeatherForecastByCity(String city) {
		logging.log(Level.INFO, "Fetching Wether Forecast Data by city:" + city);
		// Fetch weather forecast data
		WeatherForecast weatherForecast = openWeatherMapService.getWetherForecastByCity(city).getBody();

		List<WeatherEntry> filteredDailyEntries = new ArrayList<>();
		List<WeatherEntry> filteredNightlyEntries = new ArrayList<>();
		List<WeatherEntry> filteredPressureEntries = new ArrayList<>();
		// Validating day and time, and mapping entries accordingly.
		for (WeatherEntry we : weatherForecast.getEntries()) {
			Instant instant = we.getTimestamp();
			if (instant.isBefore(ForecastDateTimeUtil.getDailyStartLimit())
					|| instant.isAfter(ForecastDateTimeUtil.getDailyEndLimit())) {
				continue;
			}
			int instantHour = LocalDateTime.ofInstant(instant, ZoneOffset.UTC).getHour();
			if (instantHour >= Config.DAILY_START_HOUR && instantHour <= Config.DAILY_END_HOUR) {
				filteredDailyEntries.add(we);
			} else {
				filteredNightlyEntries.add(we);
			}
			// Add weather entries for pressure in the same iteration.
			filteredPressureEntries.add(we);
		}
		// Calculate the average of daily weather forecast for next 3 days.
		double avgDailyTemp = filteredDailyEntries.stream().mapToDouble(WeatherEntry::getTemperature).average()
				.getAsDouble();
		// Calculate the average of night weather forecast for next 3 days.
		double avgNightlyTemp = filteredNightlyEntries.stream().mapToDouble(WeatherEntry::getTemperature).average()
				.getAsDouble();
		// calculate pressure
		double avgPressure = filteredPressureEntries.stream().mapToDouble(WeatherEntry::getPressure).average()
				.getAsDouble();
		return buildAverageWeatherForecast(avgDailyTemp, avgNightlyTemp, avgPressure);
	}

	private AverageWeatherForecast buildAverageWeatherForecast(double avgDailyTemp, double avgNightlyTemp,
			double avgPressure) {
		AverageWeatherForecast averageWeatherForecast = new AverageWeatherForecast();
		averageWeatherForecast.setAvgDailyTemp(avgDailyTemp);
		averageWeatherForecast.setAvgNightlyTemp(avgNightlyTemp);
		averageWeatherForecast.setAvgPressure(avgPressure);
		System.out.println(averageWeatherForecast);
		return averageWeatherForecast;
	}

}