package com.journaldev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.journaldev.spring.delegate.api.APIService;
import com.journaldev.spring.modal.weather.CityWeatherData;



@RestController
public class APIController {

	@Autowired
	APIService apiService;
	
	@Value("${ACCUWEATHER_API_KEY}")
	String apiKey;
	
	
	
//	http://dataservice.accuweather.com/currentconditions/v1/202396/historical/24?apikey=lKnDGJHiJgAOesDpm2FnHJQbsCHyejAD
//	lKnDGJHiJgAOesDpm2FnHJQbsCHyejAD
	//should not return any value
	//should not be passed any parameters....
	//@Scheduled(cron="0 0 0/2 * * ?")
	@Scheduled(cron="0 0 0/2 * * ?")
	public void  getDelhiWeatherDataTask() {
			try {
				RestTemplate restTemplate = new RestTemplate();
				int cityId = 202396;
				String apiURL = "http://dataservice.accuweather.com/currentconditions/v1/202396/historical/24?apikey="+apiKey;
				String response = restTemplate.getForObject(apiURL, String.class);
				CityWeatherData cityWeatherData = new CityWeatherData();
				cityWeatherData.setCityId(cityId);
				cityWeatherData.setResponse(response);
				apiService.saveWeatherData(cityWeatherData);
			} catch(Exception e) {
				e.printStackTrace();
			}			
	}
	
	@Scheduled(cron="0 0 0/2 * * ?")
	public void  getGurgaonWeatherDataTask() {
			try {
				RestTemplate restTemplate = new RestTemplate();
				int cityId = 188408;
				String apiURL = "http://dataservice.accuweather.com/currentconditions/v1/188408/historical/24?apikey="+apiKey;
				String response = restTemplate.getForObject(apiURL, String.class);
				CityWeatherData cityWeatherData = new CityWeatherData();
				cityWeatherData.setCityId(cityId);
				cityWeatherData.setResponse(response);
				apiService.saveWeatherData(cityWeatherData);
			} catch(Exception e) {
				e.printStackTrace();
			}			
	}
	
	@RequestMapping(value="getWeatherData/{cityId}",method=RequestMethod.GET)
	public String getCurrentWeatherData(@PathVariable("cityId") int cityId) {
			     try {
			    	 String response = apiService.getCurrentWeatherData(cityId);
			    	 System.out.println("the response of api is "+response);
			    	 return response;
			     } catch(Exception e) {
			    	 e.printStackTrace();
			    	 return "-1";
			     }
	}
	
	
}
