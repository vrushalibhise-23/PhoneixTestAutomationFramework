package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.api.POJO.UserCredentials;
import com.api.constants.Role;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AuthTokenProvider {
	
	private AuthTokenProvider() {
		
	}
	
	public static String getToken(Role role) throws IOException {
		
		UserCredentials usercredentials=null; 
		
		//UserCredentials usercredentials = new UserCredentials("iamfd","password");
		
		if(role==role.FD) {
			 usercredentials = new UserCredentials("iamfd","password");
		}
		
		if(role==role.SUP) {
			usercredentials = new UserCredentials("iamsup","password");
		}
		
		if(role==role.ENG) {
			 usercredentials = new UserCredentials("iameng","password");
		}
		
		if(role==role.QC) {
			usercredentials = new UserCredentials("iamqc","password");
		}
		
		
		String token =given()
		.baseUri(ConfigManager.getproperty("BASE_URI"))
		.contentType(ContentType.JSON)
		.body(usercredentials) 
		.when()
		.post("login")
		.then()
		.statusCode(200)
		.log().all()
		.extract()
		.body()
		.jsonPath()
		.getString("data.token");
		return token;
		
	}

	
}
