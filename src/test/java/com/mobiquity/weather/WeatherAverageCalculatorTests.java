package com.mobiquity.weather;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mobiquity.weather.utils.WeatherAverageCalculator;

public class WeatherAverageCalculatorTests {

	@Autowired
	private WeatherAverageCalculator calculator;

	@Before
	public void setUp() {
		calculator = new WeatherAverageCalculator();
	}
	
	@Test
	public void  getDailyStatistics() {
        assertEquals("The Daily wheater Average is Correct", 8.00, 8.00, 0);
    }

	@Test
	public void  getNightlyStatistics() {
       
        assertEquals("The Nightly wheater Average is Correct", 4.00, 4.00, 0);
    }
}
