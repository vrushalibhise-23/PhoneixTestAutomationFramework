package com.api.services;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import com.api.request.model.UserCredentials;
import com.api.utils.SpecUtil;

import io.restassured.response.Response;

public class AuthService {
	
	public static final String LOGIN_ENDPOINT ="/login";

	public Response login(UserCredentials usercredentials) throws IOException {
		Response response = given()
		.spec(SpecUtil.requestSpec(usercredentials))	
		.when()
		.log().all()
		.post(LOGIN_ENDPOINT);
		
		
		return response;
	}
}
