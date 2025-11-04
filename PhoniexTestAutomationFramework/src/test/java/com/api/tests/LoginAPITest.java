package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.POJO.UserCredentials;
import com.api.utils.ConfigManager;
import com.api.utils.ConfigManager2;
import com.api.utils.SpecUtil;

import io.restassured.http.ContentType;

public class LoginAPITest {
	@Test
	public void loginAPI() throws IOException {
		
		UserCredentials usercredentials = new UserCredentials("iamfd","password");
		
		given()
		.spec(SpecUtil.requestSpec(usercredentials))	
		.when()
		.log().all()
		.post("/login")
		.then()
		.spec(SpecUtil.responseSpecification())

       ;
		
		
		
		
		
	}

}
