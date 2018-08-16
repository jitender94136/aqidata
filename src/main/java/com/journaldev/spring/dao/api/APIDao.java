package com.journaldev.spring.dao.api;

import com.journaldev.spring.modal.weather.CityWeatherData;

public interface APIDao {

	public void saveWeatherData(CityWeatherData cityWeatherData);

	public String getCurrentWeatherData(int cityId);
}
