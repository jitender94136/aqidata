package com.journaldev.spring.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.modal.Record;


@Repository
public class RecordDaoImpl implements RecordDao {

    private JdbcTemplate jdbcTemplate;
	
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	
	@Override
	public List<Record> getRecords() {
		String sql = "select * from record" ;
		List<Record> records = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Record>(Record.class));
		return records;
		//return null;
	}


	@Override
	public Record getLatestRecord() {
		String sql = "select * from record order by id desc limit 1";
		return jdbcTemplate.queryForObject(sql , new BeanPropertyRowMapper<Record>(Record.class));
		//return null;
	}



	
	@Override
	public List<Record> getCurrentDayRecords() {
		String sql = "select * from record where date(timestamp) = date(now()) order by id desc limit 10";
		List<Record> records = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Record>(Record.class));;
		return records;
	}
	
	
	@Override
	public List<Record> getWeeklyRecords() {
		String sql = "select * from record order by id desc limit 5";
		List<Record> records = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Record>(Record.class));;
		return records;
	}
	
	@Override
	public List<Record> getMonthlyRecords() {
		String sql = "select * from record order by id desc limit 5";
		List<Record> records = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Record>(Record.class));;
		return records;
	}

	@Override
	public List<Record> getYearlyRecords() {
		String sql = "select * from record order by id desc limit 5";
		List<Record> records = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Record>(Record.class));;
		return records;
	}


	@Override
	public Record getSecondSensorRecords() {
		String sql = "select * from record_2 order by id desc limit 1";
		return jdbcTemplate.queryForObject(sql , new BeanPropertyRowMapper<Record>(Record.class));
	}


	@Override
	public List<Record> getCurrentDaySecondSensorRecords() {
		String sql = "select * from record_2 where date(timestamp) = date(now()) order by id desc limit 10";
		List<Record> records = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Record>(Record.class));;
		return records;
	}


	@Override
	public List<Record> getCentralParkFeed() {
		Connection con = null;
		List<Record> records = new ArrayList<Record>();
		try {
			con = jdbcTemplate.getDataSource().getConnection();
			String sql = "call fl_get_central_park_feed()";
			CallableStatement cstmt = con.prepareCall(sql);
			ResultSet rs = cstmt.executeQuery();
			while(rs.next()) {
						Record record = new Record();
						record.setPm2(rs.getString("avgpm2"));
						record.setTimestamp(rs.getString("timestamp"));
						records.add(record);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return records;
	}
	
	
	
	
}
