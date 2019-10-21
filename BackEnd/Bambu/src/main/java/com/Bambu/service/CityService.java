package com.Bambu.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.Bambu.model.Trie;

import org.json.JSONArray;
import org.json.JSONObject;

@Service
public class CityService {
	
	JSONArray countries;
	Trie t= new Trie();
	Logger logger = LoggerFactory.getLogger(this.getClass());
	public CityService() {

	    try {
	        logger.info("An INFO Message");	   
			Resource resource = new ClassPathResource("cities.json");
			InputStream input = resource.getInputStream();
		    File file = resource.getFile();
			String content = new String(Files.readAllBytes(file.toPath()));
		    countries = new JSONArray(content); 	//cities.json source: https://gist.github.com/keeguon/2310008				    
	
		    //populate to trie tree
		    countries.forEach(o->{
		    	JSONObject country = (JSONObject)o;		
		    	t.insert(country.get("name").toString().toLowerCase());
		    });
		  
		  
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public Trie getTrieTree() {
		return t;
	}
	
	
}
