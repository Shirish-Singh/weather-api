package com.fl.weather.json.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class WeatherForecast implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1158561827267958855L;

	private List<WeatherEntry> entries = new ArrayList<>();

	@JsonProperty("entries")
	public List<WeatherEntry> getEntries() {
		return this.entries;
	}

	@JsonSetter("list")
	public void setEntries(List<WeatherEntry> entries) {
		this.entries = entries;
	}

}
