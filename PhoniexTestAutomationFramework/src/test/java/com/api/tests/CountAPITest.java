package com.api.tests;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constants.Role;
import static com.api.utils.SpecUtil.*;

import io.restassured.RestAssured;


public class CountAPITest {
	@Test(description="Verify if Count API is giving correct response",groups= {"api","smoke","regression"})
	public void CountAPI() throws IOException {
		
		RestAssured.given()
		.spec(requestSpecwithAuth(Role.FD))
		.when()
		.get("/dashboard/count")
		.then()
		.log().all()
		.spec(responseSpecification())
		.body("data", Matchers.notNullValue())
		.body("data.size()", Matchers.equalTo(3))
		.body("data.count", Matchers.everyItem(Matchers.greaterThanOrEqualTo(0)));
		//.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ResponseSchema/CountAPISchema.json"));
		}
	
	@Test(description="Verify if Count API is giving correct status code for missing token",groups= {"api","smoke","regression"})
public void CountAPI_missingAuthToken() throws IOException {
		
		RestAssured.given()
		.spec(requestSpec())
		//.header("Authorization",AuthTokenProvider.getToken(Role.FD))
		.when()
		.get("/dashboard/count")
		.then()
		.log().all()
		.spec(responseSpecification_401());

}}
