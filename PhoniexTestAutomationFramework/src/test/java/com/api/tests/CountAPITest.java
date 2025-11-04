package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.POJO.UserCredentials;
import com.api.constants.Role;
import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;
import com.api.utils.ConfigManager2;
import com.api.utils.SpecUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;


public class CountAPITest {
	@Test
	public void CountAPI() throws IOException {
		
		RestAssured.given()
		.spec(SpecUtil.requestSpecwithAuth(Role.FD))
		.when()
		.get("/dashboard/count")
		.then()
		.log().all()
		.spec(SpecUtil.responseSpecification())
		.body("data", Matchers.notNullValue())
		.body("data.size()", Matchers.equalTo(3))
		.body("data.count", Matchers.everyItem(Matchers.greaterThanOrEqualTo(0)));
		//.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ResponseSchema/CountAPISchema.json"));
		}
	
	@Test
public void CountAPI_missingAuthToken() throws IOException {
		
		RestAssured.given()
		.spec(SpecUtil.requestSpec())
		//.header("Authorization",AuthTokenProvider.getToken(Role.FD))
		.when()
		.get("/dashboard/count")
		.then()
		.log().all()
		.spec(SpecUtil.responseSpecification_401());

}}
