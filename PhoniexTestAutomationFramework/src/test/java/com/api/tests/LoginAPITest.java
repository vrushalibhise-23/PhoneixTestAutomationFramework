package com.api.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.request.model.UserCredentials;
import com.api.utils.SpecUtil;

public class LoginAPITest {
	UserCredentials usercredentials;
	
	@BeforeMethod(description="Create the payload for login api")
	public void setup() {
		 usercredentials = new UserCredentials("iamfd","password");
	}
	
	@Test(description="Verify if login api is working for FD user", groups= {"smoke","regression","api"})
	public void loginAPI() throws IOException {
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
