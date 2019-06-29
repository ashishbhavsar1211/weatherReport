package com.mobiquity.weather.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecast {
	public String cod;
	public String message;
	public Long cnt;
	public List<WeatherDetails> list;
	public City city;
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	public List<WeatherDetails> getList() {
		return list;
	}
	public void setList(List<WeatherDetails> list) {
		this.list = list;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	
}

