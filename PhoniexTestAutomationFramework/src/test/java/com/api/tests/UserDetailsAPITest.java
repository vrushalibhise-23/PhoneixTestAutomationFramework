package com.api.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.utils.SpecUtil;

public class UserDetailsAPITest {

	@Test(description="Verify if user details api response is shown correctly" ,groups= {"api","smoke","regression"})
	public void userdetailsAPI() throws IOException {
		//Header header = new Header("Authorization",getToken(Role.ENG));
		given()
		.spec(SpecUtil.requestSpecwithAuth(Role.FD))
		.when()
		.get("userdetails")
		.then()
		.spec(SpecUtil.responseSpecification());
	}
}
