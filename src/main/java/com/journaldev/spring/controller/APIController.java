package com.journaldev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.journaldev.spring.delegate.api.APIService;
import com.journaldev.spring.modal.weather.CityWeatherData;
import com.journaldev.spring.utility.Utility;



@RestController
public class APIController {

	@Autowired
	APIService apiService;
	
	@Value("${ACCUWEATHER_API_KEY}")
	String apiKey;
	
	@Value("${GURGAON_CITY_ID}")
	int gurgaonCityId;
	
	@Value("${DELHI_CITY_ID}")
	int delhiCityId;
	
	
//	http://dataservice.accuweather.com/currentconditions/v1/202396/historical/24?apikey=lKnDGJHiJgAOesDpm2FnHJQbsCHyejAD
//	lKnDGJHiJgAOesDpm2FnHJQbsCHyejAD
	//should not return any value
	//should not be passed any parameters....
	//@Scheduled(cron="0 0 0/2 * * ?")
	@Scheduled(cron="0 0 0/2 * * ?")
	public void  getDelhiWeatherDataTask() {
			try {
				RestTemplate restTemplate = new RestTemplate();
				int cityId = delhiCityId;
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
				int cityId = gurgaonCityId;
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
	
	//For this rest request to work property we have to include the certificate in java key store......
	@RequestMapping("getCPCBSiteData/{siteId}")
	public String getCPCBSiteData(@PathVariable("siteId") int siteId) {
	     try {
	    	 String encFormData = "{\"site_id\":\"site_"+siteId+"\",\"user_id\":\"user_211\",\"user_name\":\"KSPCB\",\"user_role\":\"Admin\",\"org\":[\"KSPCB\"]}";
	    	 encFormData = Utility.encodeBase64(encFormData);
	    	 String apiURL = "https://app.cpcbccr.com/caaqms/caaqms_view_data";
	    	 RestTemplate restTemplate = new RestTemplate();
	    	 HttpHeaders headers = new HttpHeaders();
	    	 headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	    	 MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
	    	 map.add(encFormData, "");
	    	 HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(map, headers);
	    	 ResponseEntity<String> responseEntity = restTemplate.postForEntity( apiURL, requestEntity, String.class);
	    	 String responseBody = responseEntity.getBody();
	    	 return responseBody;
	     } catch(Exception e) {
	    	 e.printStackTrace();
	    	 return "-1";
	     }
    }
	
	
	
	
}
