package com.mobiquity.weather.entities;

public class WeatherAverages {
	public double dailyAverageTemperature;
	public double nightlyAverageTemperature;
	public double pressureAverage;
	public double getDailyAverageTemperature() {
		return dailyAverageTemperature;
	}
	public void setDailyAverageTemperature(double dailyAverageTemperature) {
		this.dailyAverageTemperature = dailyAverageTemperature;
	}
	public double getNightlyAverageTemperature() {
		return nightlyAverageTemperature;
	}
	public void setNightlyAverageTemperature(double nightlyAverageTemperature) {
		this.nightlyAverageTemperature = nightlyAverageTemperature;
	}
	public double getPressureAverage() {
		return pressureAverage;
	}
	public void setPressureAverage(double pressureAverage) {
		this.pressureAverage = pressureAverage;
	}
	
	
}
