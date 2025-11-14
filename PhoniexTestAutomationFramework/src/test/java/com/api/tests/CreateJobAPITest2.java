package com.api.tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

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
import com.github.javafaker.Faker;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobAPITest2 {
	CreateJobPayload jobpayload ;
	private static final  String Country ="India";
	
	@BeforeMethod(description="Created payload for the job")
	private void Setup() {
		Locale locale = new Locale("en-IND");
		Faker faker =  new Faker(locale);
		
		String fname = faker.name().firstName();
		String lname = faker.name().lastName();
		String mobilenumber =faker.numerify("98########");
		String altmobilenumber =faker.numerify("98########");
		String emailid =faker.internet().emailAddress();
		String altemailid =faker.internet().emailAddress();
		
		Customer customer = new Customer(fname, lname, mobilenumber, altmobilenumber, emailid, altemailid);
		System.out.println(customer);
		
		String flatno =faker.numerify("###");
		String apartmentname =faker.address().streetName();
		String streename =faker.address().streetName();
		String landmark =faker.address().streetName();
		String area =faker.address().streetName();
		String zipcode =faker.numerify("#####");
		
		String state =faker.address().state();
		
		
		CustomerAddress customeraddress= new CustomerAddress(flatno, apartmentname, streename, landmark, area, zipcode, Country, state);
		System.out.println(customeraddress);
		
		String dop =DateTimeUtil.getTimewithDaysAgo(10);
		String imeiserialnumber =faker.numerify("##############");
		String popurl = faker.internet().url();
		
		CustomerProduct customerproduct = new CustomerProduct(dop, imeiserialnumber, imeiserialnumber, imeiserialnumber, popurl, 1, 1);
		System.out.println(customerproduct);
		
		String fakeremark =faker.lorem().sentence(10);
		
		Random random = new Random();
		
		int problemsid =random.nextInt(26)+1;
		
		Problems problmes = new Problems(problemsid, fakeremark);
		
		List<Problems> problemslist = new ArrayList<Problems>();
		problemslist.add(problmes);
		
		jobpayload = new CreateJobPayload(0, 2, 1, 1, customer, customeraddress, customerproduct, problemslist);
		
	  
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
