package com.mobiquity.weather.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coord { 
	public Long lat;
	public Long lon;
}