package com.journaldev.spring.delegate.api;

import com.journaldev.spring.modal.weather.CityWeatherData;


public interface APIService {

	
				public void saveWeatherData(CityWeatherData cityWeatherData);

				public String getCurrentWeatherData(int cityId);
				
				
	
}
