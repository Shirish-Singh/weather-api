package com.fl.weather.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

import com.fl.weather.constants.Config;

public class ForecastDateTimeUtil {

	private static LocalDateTime startDateTime = LocalDateTime.of(LocalDate.now().plusDays(1),
			LocalTime.of(Config.START_HOUR_OF_DAILY_FORECAST, Config.START_MINUTE_OF_DAILY_FORECAST));
	private static LocalDateTime endDateTime = LocalDateTime.of(LocalDate.now().plusDays(Config.TOTAL_FORECAST_DAYS),
			LocalTime.of(Config.END_HOUR_OF_DAILY_FORECAST, Config.END_MINUTE_OF_DAILY_FORECAST));

	private static Instant dailyInstantStartLimit = startDateTime.toInstant(ZoneOffset.UTC);
	private static Instant dailyInstantEndLimit = endDateTime.toInstant(ZoneOffset.UTC);


	public static Instant getDailyStartLimit() {
		return dailyInstantStartLimit;
	}

	public static Instant getDailyEndLimit() {
		return dailyInstantEndLimit;
	}

}
