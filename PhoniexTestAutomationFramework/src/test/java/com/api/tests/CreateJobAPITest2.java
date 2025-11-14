package com.api.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Iterator;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.request.model.CreateJobPayload;
import com.api.utils.FakerDataGenerator;
import com.api.utils.SpecUtil;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobAPITest2 {
	Iterator<CreateJobPayload> jobpayload;
	private static final String Country = "India";

	@BeforeMethod(description = "Created payload for the job")
	private void Setup() {

		jobpayload = FakerDataGenerator.generateFakeCreateJobData(10);
	}

	@Test(description = "Verify if Create Job  API is giving correct response", groups = { "api", "smoke",
			"regression" })
	public void createJobAPITest() throws IOException {

		given().spec(SpecUtil.requestSpecwithAuth(Role.FD, jobpayload)).when().log().all().post("/job/create") // ✅
																												// Replace
																												// with
																												// actual
																												// endpoint
																												// path
				.then().spec(SpecUtil.responseSpecification())
				.body("message", Matchers.equalTo("Job created successfully. "))
				.body("data.mst_service_location_id", Matchers.equalTo(1))
				.body("data.job_number", Matchers.startsWith("JOB_"))
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ResponseSchema/CreateJobAPISchema.json"));
	}
}
