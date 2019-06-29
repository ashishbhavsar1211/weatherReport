package com.mobiquity.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.mobiquity.weather.entities.WeatherAverages;
import com.mobiquity.weather.exception.CityNotFoundException;
import com.mobiquity.weather.services.WeatherServicesImpl;

@RestController
@Validated
public class WeatherController {

	
	@Autowired
	private WeatherServicesImpl weatherServicesImpl;

	@RequestMapping(value = "/v1.0/data", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody WeatherAverages data(@RequestParam("city") String city) throws CityNotFoundException {
		return weatherServicesImpl.getWeatherForecastByCity(city);
	}
}
