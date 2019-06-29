
package com.mobiquity.weather.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Clouds {
	public Long all;
}
