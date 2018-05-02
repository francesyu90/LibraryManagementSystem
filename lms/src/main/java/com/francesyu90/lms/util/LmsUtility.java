package com.francesyu90.lms.util;

import java.util.List;

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
	
	public String getLibrariesJSONString(List<Library> libraries) {
		Gson gsonBuilder = new GsonBuilder().create();
		return gsonBuilder.toJson(libraries);
	}

}
