package com.api.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.POJO.CreateJobPayload;
import com.api.POJO.Customer;
import com.api.POJO.CustomerAddress;
import com.api.POJO.CustomerProduct;
import com.api.POJO.Problems;
import com.api.constants.Role;
import com.api.utils.SpecUtil;

public class CreateJobAPITest {
  
	@Test
	public void createJobAPITest() throws IOException {
		 Customer customer = new Customer("Vrushali", "bhise", "23554332222","", "vrushalibhise16@gmail.com", "");
		  CustomerAddress customeraddress =  new CustomerAddress("CR402", "lakshaddep", "pimple saudagar", "Pune", "pune", "41021", "India", "Maharashtra");
		  CustomerProduct product = new CustomerProduct("2025-07-31T18:30:00.000Z", "116699443334910", "116699443334910", "116699443334910", "2025-07-31T18:30:00.000Z", 3, 3);
		  Problems problems = new Problems(1, "Battery issue");
		  Problems[] problemsArray = new Problems[1];
		  problemsArray[0]=problems;
		  CreateJobPayload jobpayload = new CreateJobPayload(0, 2, 1, 2, customer, customeraddress, product, problemsArray);
		  
		  
	    given()
	      .spec(SpecUtil.requestSpecwithAuth(Role.FD, jobpayload))
	    .when()
	        .log().all()
	        .post("/job/create")   // ✅ Replace with actual endpoint path
	    .then()
	    .spec(SpecUtil.responseSpecification());
	}
}
