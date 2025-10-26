package com.api.tests;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;

import static io.restassured.RestAssured.*;
import io.restassured.response.ValidatableResponse;

public class MasterAPITest {
	@Test
	public void MasterAPITest() throws IOException {
		ValidatableResponse response= given()
		.baseUri(ConfigManager.getproperty("BASE_URI"))
		.and()
		.contentType("")
		.header("Authorization",AuthTokenProvider.getToken(Role.FD))
		.when()
		.post("master")
		.then()
		.log().all()
		.statusCode(200)
		.time(Matchers.lessThan(1000L))
		.body("message", Matchers.equalTo("Success"))
		.body("data",Matchers.hasKey("mst_oem"))
		 .body("data", Matchers.hasKey("mst_model"))
		 .body("data.mst_oem.size()", Matchers.greaterThan(0))
		 .body("data.mst_oem.id", Matchers.everyItem(Matchers.notNullValue()));
		
	}
	@Test
	public void MasterAPITest_invalidtoken() throws IOException {
		ValidatableResponse response = given()
			    .baseUri(ConfigManager.getproperty("BASE_URI"))
			    .and()
			    .contentType("application/json") // don’t leave it blank
			    //.header("Authorization", AuthTokenProvider.getToken(Role.FD))
			.when()
			    .post("master")
			.then()
			    .statusCode(401)
			    .log().all();
		
	}
}
