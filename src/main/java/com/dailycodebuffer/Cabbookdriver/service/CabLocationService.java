package com.dailycodebuffer.Cabbookdriver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.dailycodebuffer.Cabbookdriver.config.AppConstants;

@Service
public class CabLocationService {

	@Autowired
	KafkaTemplate<String, Object> kafkaTemplate;
	
	public boolean updateLocation(String location) {
		kafkaTemplate.send(AppConstants.CAB_LOCATION, location);
		return true;
	}
	
}
