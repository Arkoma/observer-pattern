package com.aaron.observerpattern;

import com.aaron.observerpattern.display.CurrentConditionsDisplay;
import com.aaron.observerpattern.display.ForecastDisplay;
import com.aaron.observerpattern.display.StatisticsDisplay;
import com.aaron.observerpattern.model.WeatherData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObserverpatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObserverpatternApplication.class, args);

		WeatherData weatherData = new WeatherData();

		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}

}
