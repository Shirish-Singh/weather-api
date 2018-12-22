package com.fl.weather.json.pojo;

import java.io.Serializable;
import java.time.Instant;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class WeatherEntry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3078274958381749094L;

	private Instant timestamp;

	private double temperature;

	private double pressure;

	@JsonProperty("timestamp")
	public Instant getTimestamp() {
		return timestamp;
	}

	@JsonSetter("dt")
	public void setTimestamp(long unixTime) {
		this.timestamp = Instant.ofEpochMilli(unixTime * 1000);
	}

	@JsonProperty("main")
	public void setMain(Map<String, Object> main) {
		setTemperature(Double.parseDouble(main.get("temp").toString()));
		setPressure(Double.parseDouble(main.get("pressure").toString()));
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getPressure() {
		return pressure;
	}

	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

}
