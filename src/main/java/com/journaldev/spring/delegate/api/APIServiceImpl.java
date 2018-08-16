package com.journaldev.spring.delegate.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journaldev.spring.dao.api.APIDao;
import com.journaldev.spring.modal.weather.CityWeatherData;


@Service
public class APIServiceImpl implements APIService {

	@Autowired
	APIDao apiDao;

	@Override
	@Transactional
	public void saveWeatherData(CityWeatherData cityWeatherData) {
		apiDao.saveWeatherData(cityWeatherData);	
	}

	@Override
	public String getCurrentWeatherData(int cityId) {
		
		return apiDao.getCurrentWeatherData(cityId);
	}
	



	

}
