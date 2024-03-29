package com.mobiquity.weather;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class WeatherTestsHelper {

	public static List<com.mobiquity.weather.entities.WeatherDetails> getDailyWeatherDetails() {
		List<com.mobiquity.weather.entities.WeatherDetails> list = new ArrayList<>();

		com.mobiquity.weather.entities.WeatherDetails wd1 = new com.mobiquity.weather.entities.WeatherDetails();
		wd1.setDt(Instant.parse("2018-12-15T06:00:00Z"));
		com.mobiquity.weather.entities.Main main1 = new com.mobiquity.weather.entities.Main();
		main1.setTemp(10.00);
		main1.setPressure(100.00);
		main1.setTemp_min(10.00);
		main1.setTemp_max(10.00);
		main1.setSea_level(1041.39);
		main1.setHumidity(86);
		main1.setTemp_kf(0.75);
		main1.setGrnd_level(1035.5);
		wd1.setMain(main1);
		list.add(wd1);

		com.mobiquity.weather.entities.WeatherDetails wd2 = new com.mobiquity.weather.entities.WeatherDetails();
		wd1.setDt(Instant.parse("2018-12-15T09:00:00Z"));
		com.mobiquity.weather.entities.Main main2 = new com.mobiquity.weather.entities.Main();
		main2.setTemp(6.00);
		main2.setPressure(200.00);
		main2.setTemp_min(10.00);
		main2.setTemp_max(10.00);
		main2.setSea_level(1041.39);
		main2.setHumidity(86);
		main2.setTemp_kf(0.75);
		main2.setGrnd_level(1035.5);
		wd2.setMain(main2);
		list.add(wd2);
		
		//Should not be taken into consideration as is not a day time value
		com.mobiquity.weather.entities.WeatherDetails wd3 = new com.mobiquity.weather.entities.WeatherDetails();
		wd3.setDt(Instant.parse("2018-12-15T21:00:00Z"));
		com.mobiquity.weather.entities.Main main3 = new com.mobiquity.weather.entities.Main();
		main2.setTemp(4.00);
		main2.setPressure(100.00);
		main2.setTemp_min(10.00);
		main2.setTemp_max(10.00);
		main2.setSea_level(1041.39);
		main2.setHumidity(86);
		main2.setTemp_kf(0.75);
		main2.setGrnd_level(1035.5);
		wd3.setMain(main3);
		list.add(wd3);
		
		return list;
	}
}
