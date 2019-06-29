package com.mobiquity.weather.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City {
	public Long id;
	public String name;
	public Coord coord;
	public String country;
	public String population;
}
