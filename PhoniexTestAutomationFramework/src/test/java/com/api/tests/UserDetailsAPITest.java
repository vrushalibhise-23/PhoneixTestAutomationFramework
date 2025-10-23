package com.api.tests;

import static io.restassured.RestAssured.*;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static com.api.utils.AuthTokenProvider.*;

import com.api.constants.Role;
import com.api.utils.ConfigManager;
import com.api.utils.ConfigManager2;

import io.restassured.http.Header;

public class UserDetailsAPITest {

	@Test
	public void userdetailsAPI() throws IOException {
		Header header = new Header("Authorization",getToken(Role.ENG));
		given()
		.baseUri(ConfigManager2.getproperty("BASE_URI"))
		.and()
		.header(header)
		.when()
		.get("userdetails")
		.then()
		.log().all()
		.statusCode(200)
		.body("message", Matchers.equalTo("Success"));
	}
}
