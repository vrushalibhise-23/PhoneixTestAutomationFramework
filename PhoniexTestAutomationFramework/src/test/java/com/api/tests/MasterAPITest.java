package com.api.tests;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;

import static io.restassured.RestAssured.*;
import io.restassured.response.ValidatableResponse;

public class MasterAPITest {
	@Test
	public void MasterAPITest() throws IOException {
		ValidatableResponse response= given()
		.spec(SpecUtil.requestSpecwithAuth(Role.FD))
		.when()
		.post("master")
		.then()
		.spec(responseSpecification)
		
		.body("data",Matchers.hasKey("mst_oem"))
		 .body("data", Matchers.hasKey("mst_model"))
		 .body("data.mst_oem.size()", Matchers.greaterThan(0))
		 .body("data.mst_oem.id", Matchers.everyItem(Matchers.notNullValue()));
		
	}
	@Test
	public void MasterAPITest_invalidtoken() throws IOException {
		ValidatableResponse response = given()
				.spec(SpecUtil.requestSpec()) // don’t leave it blank
			    //.header("Authorization", AuthTokenProvider.getToken(Role.FD))
			.when()
			    .post("master")
			.then()
			 .spec(SpecUtil.responseSpecification_401());
		
	}
}
