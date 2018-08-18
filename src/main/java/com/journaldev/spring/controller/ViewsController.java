package com.journaldev.spring.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.journaldev.spring.delegate.RecordService;
import com.journaldev.spring.modal.Record;

/**
 * Handles requests for the application file upload requests
 */
@Controller
public class ViewsController {

	//private static final Logger logger = LoggerFactory.getLogger(ViewsController.class);
	
	@Autowired
	RecordService recordService;

	@Value("${GURGAON_CPCB_SITE_ID}")
	String gurgaonCPCBSiteId;
	
	@RequestMapping(value = "/aqi", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Record record = recordService.getLatestRecord();
		mv.addObject("record", record);
		mv.addObject("gurgaonCPCBSiteId", gurgaonCPCBSiteId);
		mv.setViewName("index");
		return mv;
	}

	@RequestMapping(value = "/compareaqi", method = RequestMethod.GET)
	public ModelAndView tableView(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Record record = recordService.getLatestRecord();
		Record secondSensorRecord = recordService.getSecondSensorRecords();
		List<Record> firstSensorRecords = recordService.getCurrentDayRecords();
		List<Record> secondSensorRecords = recordService.getCurrentDaySecondSensorRecords();
		mv.addObject("record", record);
		mv.addObject("secondSensorRecord",secondSensorRecord);
		mv.addObject("firstSensorRecords", firstSensorRecords);
		mv.addObject("secondSensorRecords", secondSensorRecords);
		mv.setViewName("tableview");
		return mv;
	}
	
	public void testAQICalculator() {
		//AQICalculator calculator = AQICalculator.getAQICalculatorInstance();
		//AQIResult result = calculator.getAQI(Pollutant.PM10, 99);	
	}
		

}
