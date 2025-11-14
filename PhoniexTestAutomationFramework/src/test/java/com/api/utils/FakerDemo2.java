package com.api.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import com.github.javafaker.Faker;

public class FakerDemo2 {
     private static final  String Country ="India";
	public static void main(String[] args) {
		
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
		
		CreateJobPayload createjobpayload = new CreateJobPayload(0, 2, 1, 1, customer, customeraddress, customerproduct, problemslist);
		System.out.println(createjobpayload);
	}

}
