package com.mobiquity.weather.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {
	public double speed;
	public double deg;
}
