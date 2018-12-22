package com.fl.weather.model;

public class AverageWeatherForecast {

	private double avgNightlyTemp;
	private double avgDailyTemp;
	private double avgPressure;

	public double getAvgNightlyTemp() {
		return avgNightlyTemp;
	}

	public void setAvgNightlyTemp(double avgNightlyTemp) {
		this.avgNightlyTemp = avgNightlyTemp;
	}

	public double getAvgDailyTemp() {
		return avgDailyTemp;
	}

	public void setAvgDailyTemp(double avgDailyTemp) {
		this.avgDailyTemp = avgDailyTemp;
	}

	public double getAvgPressure() {
		return avgPressure;
	}

	public void setAvgPressure(double avgPressure) {
		this.avgPressure = avgPressure;
	}

	@Override
	public String toString() {
		return "AverageWeatherForecast [avgNightlyTemp=" + avgNightlyTemp + ", avgDailyTemp=" + avgDailyTemp
				+ ", avgPressure=" + avgPressure + "]";
	}

}
