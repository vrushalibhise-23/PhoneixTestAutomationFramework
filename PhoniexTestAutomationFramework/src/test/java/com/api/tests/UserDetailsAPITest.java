package com.api.tests;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static com.api.utils.AuthTokenProvider.*;

import com.api.constants.Role;
import com.api.utils.ConfigManager;
import com.api.utils.ConfigManager2;
import com.api.utils.SpecUtil;

import io.restassured.http.Header;

public class UserDetailsAPITest {

	@Test
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
