package com.francesyu90.lms.util;

import org.springframework.stereotype.Component;

import com.francesyu90.lms.domain.Library;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class LmsUtility {
	
	public String getLibraryJSONString(Library library) {
		Gson gsonBuilder = new GsonBuilder().create();
		String jsonFromPojo = gsonBuilder.toJson(library);
		return jsonFromPojo;
	}

}
