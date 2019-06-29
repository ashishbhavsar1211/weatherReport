# Title
Java Case Study – Weather forecast 

# Task

The task:  Using Java (1.8 or newer), create an API that will retrieve weather metrics of a specific city. Please use ​https://openweathermap.org/​ to create a free account and retrieve the data for this case study.  
 
The requirements:  ✓ The API should produce a endpoint to retrieve the averages 
 ✓ The endpoint should return a JSON object that gives the averages of the following metrics: 
     o Average of daily (06:00 – 18:00) and nightly (18:00 – 06:00) temperatures in Celsius for the next 3 days from today’s date.
	 o Average of pressure for the next 3 days from today’s date. 
 ✓ The endpoint must include a CITY parameter containing the city’s name as the input for the correct response.  
 
# Tools Used

Spring Boot.

Java 8.

## 

Import into your IDE as existing Maving project and run.

or

Donwload the soruce code and navigate to the root folder where the pom.xml is located and run 

`mvn clean Install`

`mvn spring-boot:run`


# Example of usage 

[http://localhost:8080/weather/data?city=mumbai](http://localhost:8080/weather/data?city=mumbai)

Will generate a result like this: 

`{
  "dailyAverageTemperature" : 28.56,
  "nightlyAverageTemperature" : 28.0,
  "pressureAverage" : 1004.15
}`
