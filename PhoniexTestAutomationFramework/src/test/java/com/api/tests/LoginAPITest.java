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

import io.restassured.http.ContentType;

public class LoginAPITest {
	@Test
	public void loginAPI() throws IOException {
		
		UserCredentials usercredentials = new UserCredentials("iamfd","password");
		
		given()
		.baseUri(ConfigManager2.getproperty("BASE_URI"))
		.and()
		.contentType(ContentType.JSON)
		.and()
		.body(usercredentials)
		.log().uri()
		.log().headers()
		.log().body()
		.log().method()		
		.when()
		.log().all()
		.post("/login")
		.then()
		.statusCode(200)
		.time(lessThan(1000L))
		.body("message",equalTo("Success"))
		.body("data.token",notNullValue())
		.extract()
        .path("data.token")
       ;
		
		
		
		
		
	}

}
