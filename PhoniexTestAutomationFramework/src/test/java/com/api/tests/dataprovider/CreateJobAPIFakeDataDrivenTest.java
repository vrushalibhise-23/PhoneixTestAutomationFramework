package com.api.tests.dataprovider;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.request.model.CreateJobPayload;
import com.api.utils.SpecUtil;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobAPIFakeDataDrivenTest {

  
	@Test(description="Verify if Create Job  API is giving correct response",groups= 
		{"api","smoke","regression"},dataProviderClass=com.dataprovider.DataProviderUtils.class,dataProvider="CreateJobFakerAPIDataProvider")
	public void createJobAPITest(CreateJobPayload jobpayload) throws IOException {
		
		  
	    given()
	      .spec(SpecUtil.requestSpecwithAuth(Role.FD, jobpayload))
	    .when()
	        .log().all()
	        .post("/job/create")   // ✅ Replace with actual endpoint path
	    .then()
	    .spec(SpecUtil.responseSpecification())
	    .body("message", Matchers.equalTo("Job created successfully. "))
	    .body("data.mst_service_location_id", Matchers.equalTo(1))
	    .body("data.job_number", Matchers.startsWith("JOB_"));
	    
	}
}
