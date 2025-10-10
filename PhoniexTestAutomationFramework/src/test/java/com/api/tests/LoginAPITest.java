package com.api.tests;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.api.POJO.UserCredentials;

import io.restassured.http.ContentType;

public class LoginAPITest {
	@Test
	public void loginAPI() {
		
		UserCredentials usercredentials = new UserCredentials("iamfd","password");
		
		given()
		.baseUri("http://64.227.160.186:9000/v1")
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
        .path("data.token");
		
		
		
		
		
	}

}
