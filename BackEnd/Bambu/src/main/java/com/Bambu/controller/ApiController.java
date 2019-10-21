package com.Bambu.controller;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Bambu.service.CityService;
import org.json.JSONObject;
import org.json.JSONArray;
@RestController
public class ApiController {
	
	
	@Autowired
	CityService cityService;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	// /api/getCities?city=abc
	@CrossOrigin 
	@RequestMapping("/api/getCities")
	public ResponseEntity<List<String>> getCities(@RequestParam String city) {

	 //logger.info("param:" + city);

	  List<String> countries= cityService.getTrieTree().autocomplete(city.toLowerCase());
	 // logger.info("size is:"+countries.size());
	
	  
		return new ResponseEntity<List<String>>(countries, HttpStatus.OK);
	}
}
