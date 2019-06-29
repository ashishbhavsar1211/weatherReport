package com.mobiquity.weather.services;

import com.mobiquity.weather.entities.WeatherAverages;
import com.mobiquity.weather.exception.CityNotFoundException;

public interface WeatherServices {

	public WeatherAverages getWeatherForecastByCity(String city) throws CityNotFoundException;
}
