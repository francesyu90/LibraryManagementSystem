package com.francesyu90.lms.util;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class LmsUtility {
	
	private Gson gsonBuilder;
	
	public LmsUtility() {
		this.gsonBuilder = new GsonBuilder().create();
	}
	
	public String getJSONString(Object obj) {
		return this.gsonBuilder.toJson(obj);
	}

}
