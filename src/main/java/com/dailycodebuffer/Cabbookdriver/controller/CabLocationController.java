package com.dailycodebuffer.Cabbookdriver.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.Cabbookdriver.service.CabLocationService;

@RestController
@RequestMapping("/location")
public class CabLocationController {

	@Autowired
	private CabLocationService cabLocationService;

	
	@PutMapping
	public ResponseEntity updateLocation() throws InterruptedException {
		System.out.println("Location gps is :: ");
		int range =100;
		int x=1;
		while(range >0) {
			cabLocationService.updateLocation(Math.random()+","+Math.random()+" :"+(x++));
			Thread.sleep(1000);
			range--;
		}
		
		return new ResponseEntity<>(Map.of("message","Location updated"),HttpStatus.OK);
	}
}
