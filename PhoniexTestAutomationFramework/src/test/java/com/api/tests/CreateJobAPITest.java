package com.api.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.constants.Model;
import com.api.constants.OEM;
import com.api.constants.Platform;
import com.api.constants.Problem;
import com.api.constants.Product;
import com.api.constants.Role;
import com.api.constants.Service_location;
import com.api.constants.Warranty_Status;
import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import com.api.utils.DateTimeUtil;
import com.api.utils.SpecUtil;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobAPITest {
	CreateJobPayload jobpayload ;
	
	@BeforeMethod(description="Created payload for the job")
	private void Setup() {
	  Customer customer = new Customer("Vrushali", "bhise", "23554332222","", "vrushalibhise16@gmail.com", "");
	  CustomerAddress customeraddress =  new CustomerAddress("CR402", "lakshaddep", "pimple saudagar", "Pune", "pune", "41021", "India", "Maharashtra");
	  CustomerProduct product = new CustomerProduct(DateTimeUtil.getTimewithDaysAgo(10), "125693663131911", "125693663131911", "125693663131911", DateTimeUtil.getTimewithDaysAgo(10), 
			  Product.NEXUS_2.getCode(), Model.Nexus_2_BLUE.getCode());
	  Problems problems = new Problems(Problem.OVERHEATING.getcode(), "Battery issue");
	  List<Problems> problemsList = new ArrayList<Problems>();
	  problemsList.add(problems);
	   jobpayload = new CreateJobPayload(Service_location.SERVICE_LOCATION_A.getcode(), Platform.FRONT_DESK.getcode(), Warranty_Status.IN_WARRANTY.getcode(), OEM.GOOGLE.getcode(), customer, customeraddress, product, problemsList);
	  
  }
  
	@Test(description="Verify if Create Job  API is giving correct response",groups= {"api","smoke","regression"})
	public void createJobAPITest() throws IOException {
		
		  
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
