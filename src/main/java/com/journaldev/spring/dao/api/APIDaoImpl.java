package com.journaldev.spring.dao.api;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.modal.weather.CityWeatherData;

@Repository
public class APIDaoImpl implements APIDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveWeatherData(CityWeatherData cityWeatherData) {
		String insertSql = "insert into city_weather_data(city_id,response) values(?,?);";
		jdbcTemplate.update(insertSql,new Object[] {cityWeatherData.getCityId(),cityWeatherData.getResponse()});
	}

	@Override
	public String getCurrentWeatherData(int cityId) {
		String sql = "select response from city_weather_data where city_id = ? order by id desc limit 1";
		return jdbcTemplate.queryForObject(sql,new Object[] {cityId},String.class);
	}

	
//	@Override
//	public int saveAPIDataDelhi(GurgaonAirFeed response) {
//		
//		String sql = "insert into delhi_records () values ()";
//		
//		return 0;
//	}
//	

			
	
	
}
