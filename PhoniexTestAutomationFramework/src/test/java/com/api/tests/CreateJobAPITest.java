package com.api.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.api.constants.Role;
import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import com.api.utils.SpecUtil;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobAPITest {
  
	@Test
	public void createJobAPITest() throws IOException {
		 Customer customer = new Customer("Vrushali", "bhise", "23554332222","", "vrushalibhise16@gmail.com", "");
		  CustomerAddress customeraddress =  new CustomerAddress("CR402", "lakshaddep", "pimple saudagar", "Pune", "pune", "41021", "India", "Maharashtra");
		  CustomerProduct product = new CustomerProduct("2025-07-31T18:30:00.000Z", "125692443232911", "125692443232911", "125692443232911", "2025-07-31T18:30:00.000Z", 3, 3);
		  Problems problems = new Problems(1, "Battery issue");
		  List<Problems> problemsList = new ArrayList<Problems>();
		  problemsList.add(problems);
		  CreateJobPayload jobpayload = new CreateJobPayload(0, 2, 1, 2, customer, customeraddress, product, problemsList);
		  
		  
	    given()
	      .spec(SpecUtil.requestSpecwithAuth(Role.FD, jobpayload))
	    .when()
	        .log().all()
	        .post("/job/create")   // ✅ Replace with actual endpoint path
	    .then()
	    .spec(SpecUtil.responseSpecification())
	    .body("message", Matchers.equalTo("Job created successfully. "))
	    .body("data.mst_service_location_id", Matchers.equalTo(1))
	    .body("data.job_number", Matchers.startsWith("JOB_"))
	    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("ResponseSchema/CreateJobAPISchema.json"));
	}
}
