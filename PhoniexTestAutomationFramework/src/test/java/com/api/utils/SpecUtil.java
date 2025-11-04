package com.api.utils;

import java.io.IOException;

import org.hamcrest.Matchers;

import com.api.POJO.UserCredentials;
import com.api.constants.Role;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecUtil {

	
	public static RequestSpecification requestSpec() throws IOException {
		RequestSpecification requestspecification = new RequestSpecBuilder()
		        .setBaseUri(ConfigManager.getproperty("BASE_URI"))
		        .setContentType(ContentType.JSON)
		        .setAccept(ContentType.JSON)
		        .log(LogDetail.HEADERS)
		        .log(LogDetail.URI)
		        .log(LogDetail.METHOD)
		        .log(LogDetail.BODY)
		        .build();

		return requestspecification;
		 
		 
	}
	public static RequestSpecification requestSpec(Object payload) throws IOException {
		RequestSpecification requestspecification = new RequestSpecBuilder()
		        .setBaseUri(ConfigManager.getproperty("BASE_URI"))
		        .setContentType(ContentType.JSON)
		        .setAccept(ContentType.JSON)
		        .setBody(payload)
		        .log(LogDetail.HEADERS)
		        .log(LogDetail.URI)
		        .log(LogDetail.METHOD)
		        .log(LogDetail.BODY)
		        .build();

		return requestspecification;
		 
}
	
	public static RequestSpecification requestSpecwithAuth(Role role) throws IOException {
		RequestSpecification requestspecification = new RequestSpecBuilder()
		        .setBaseUri(ConfigManager.getproperty("BASE_URI"))
		        .setContentType(ContentType.JSON)
		        .setAccept(ContentType.JSON)
		        .addHeader("Authorization", AuthTokenProvider.getToken(role))
		        .log(LogDetail.HEADERS)
		        .log(LogDetail.URI)
		        .log(LogDetail.METHOD)
		        .log(LogDetail.BODY)
		        .build();

		return requestspecification;
		 
}
	
	public static ResponseSpecification responseSpecification() {
		ResponseSpecification  responsespecification =new ResponseSpecBuilder()
		.expectContentType(ContentType.JSON)
		.expectStatusCode(200)
		.expectResponseTime(Matchers.lessThan(1000L))
		.log(LogDetail.ALL)
		.build();
		
		
		return responsespecification;
	}
	public static ResponseSpecification responseSpecification_401() {
		ResponseSpecification  responsespecification =new ResponseSpecBuilder()
		//.expectContentType(ContentType.JSON)
		.expectStatusCode(401)
		.expectResponseTime(Matchers.lessThan(1000L))
		.log(LogDetail.ALL)
		.build();
		
		
		return responsespecification;
	}
}
