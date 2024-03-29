package com.mobiquity.weather.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {

	private static final int FORECAST_DAYS = 3;
	private static final int DAY_START = 6;
	private static final int DAY_END = 18;
	private LocalDateTime lastDayOfForecast;

	public DateUtil() {
		super();
		this.lastDayOfForecast = getLastDayOfForecast();
	}

	public LocalDateTime getLastDayOfForecast() {
		Instant today = Instant.now();
		LocalDateTime ldtLimit = LocalDateTime.ofInstant(today, ZoneOffset.UTC);
		ldtLimit = ldtLimit.plus(FORECAST_DAYS, ChronoUnit.DAYS);
		return ldtLimit;
	}

	public boolean isDateInRange(Instant dt) {
		LocalDateTime dtForecast = LocalDateTime.ofInstant(dt, ZoneOffset.UTC);
		return dtForecast.getDayOfYear() <= lastDayOfForecast.getDayOfYear();
	}

	public boolean isDayTimeForecast(Instant dt) {
		LocalDateTime dtForecast = LocalDateTime.ofInstant(dt, ZoneOffset.UTC);
		return dtForecast.getHour() >= DAY_START && dtForecast.getHour() <= DAY_END;
	}

}
