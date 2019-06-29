package com.mobiquity.weather.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.mobiquity.weather.entities.WeatherAverages;
import com.mobiquity.weather.entities.WeatherDetails;
import com.mobiquity.weather.entities.WeatherForecast;
import com.mobiquity.weather.exception.CityNotFoundException;
import com.mobiquity.weather.utils.WeatherAverageCalculator;

@Service
public class WeatherServicesImpl implements WeatherServices {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WeatherAverageCalculator weatherAvgCal;
	
	@Value("${openweathermap.appId}")
	private String appId;

	@Value("${openweathermap.url}")
	private String url;

	@Override
	public WeatherAverages getWeatherForecastByCity(String city) throws CityNotFoundException {

		WeatherForecast weatherForecast = new WeatherForecast();

		String cityForcastURL = getForcastURLforCity(city);

		try {
			weatherForecast = restTemplate.getForObject(cityForcastURL, WeatherForecast.class);
		} catch (HttpClientErrorException ex) {
			if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new CityNotFoundException(city + " not Found");
			}
		}
		WeatherAverages weatherAverages = new WeatherAverages();
		List<WeatherDetails> weatherDetails = weatherForecast.getList();
		weatherAverages.setDailyAverageTemperature(
				(double) formatValue(weatherAvgCal.getDailyAveragetemperature(weatherDetails)));
		weatherAverages.setNightlyAverageTemperature(
				(double) formatValue(weatherAvgCal.getNightlyAveragetemperature(weatherDetails)));
		weatherAverages.setPressureAverage(
				(double) formatValue(weatherAvgCal.getPressureAverage(weatherDetails)));
		return weatherAverages;
	}

	private Object formatValue(double dailyAveragetemperature) {
		return Math.round(dailyAveragetemperature * 100) / 100D;
	}

	private String getForcastURLforCity(String city) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("q", city)
				.queryParam("appId", appId).queryParam("units", "metric");
		return builder.toUriString();
	}

}
