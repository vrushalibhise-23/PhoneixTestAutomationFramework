package com.api.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import com.github.javafaker.Faker;

public class FakerDataGenerator {

	
	private static  Faker faker =  new Faker(new Locale("en-IND"));
	private static final  String Country ="India";
	private static final Random random = new Random();
	private static final int  MST_SERVICE_LOCATION_ID =0;
	private static final int MST_PLATFORM_ID=2;
    private static final int MST_WARRENTY_STATUS_ID=1;
	private static final int MST_OEM_ID=1; 
	private static final int PRODUCT_ID=1;
	private static final int MODEL_ID=1;
	
	private static final int validProblemsid[]= {1,2,3,4,5,6,7,8,9,10,11,12,15,16,17,19,20,22,24,26,27,28,29};
	
	private FakerDataGenerator() {
		
	}
	
	public static Iterator<CreateJobPayload> generateFakeCreateJobData(int count) {
		List<CreateJobPayload> listpayload= new ArrayList<CreateJobPayload>();
		for(int i=1;i<=count;i++) {
		Customer customer =  generateFakeCustomerData();
		CustomerAddress customerAddress = generateFakeCustomerAddressData();
		CustomerProduct customerproduct = generateFakeCustomerProductData();
		List<Problems> problemslist = generateFakeProblemsListData();
		CreateJobPayload payload = new CreateJobPayload(MST_SERVICE_LOCATION_ID, MST_PLATFORM_ID, MST_WARRENTY_STATUS_ID, MST_OEM_ID, generateFakeCustomerData(), generateFakeCustomerAddressData(), generateFakeCustomerProductData(), generateFakeProblemsListData());
		
		listpayload.add(payload);
		}
		return listpayload.iterator();
	}
	
	private static List<Problems> generateFakeProblemsListData() {
		int count = random.nextInt(3)+1;
		List<Problems> problemslist = new ArrayList<Problems>();
		 String fakeremark;
		 int problemsid;
		 Problems problmes ;
		for(int i=1;i<=count;i++ ) {
			
		
        fakeremark =faker.lorem().sentence(5);
		
		
	   problemsid =random.nextInt(validProblemsid.length);
		
		 problmes = new Problems(validProblemsid[problemsid], fakeremark);
		
		
		problemslist.add(problmes);
		}
		return problemslist;
	}

	private static CustomerProduct generateFakeCustomerProductData() {
		String dop =DateTimeUtil.getTimewithDaysAgo(10);
		String imeiserialnumber =faker.numerify("##############");
		String popurl = faker.internet().url();
		
		CustomerProduct customerproduct = new CustomerProduct(dop, imeiserialnumber, imeiserialnumber, imeiserialnumber, popurl, PRODUCT_ID, MODEL_ID);
		System.out.println(customerproduct);
		return customerproduct;
	}

	private static CustomerAddress generateFakeCustomerAddressData() {
		String flatno =faker.numerify("###");
		String apartmentname =faker.address().streetName();
		String streename =faker.address().streetName();
		String landmark =faker.address().streetName();
		String area =faker.address().streetName();
		String zipcode =faker.numerify("#####");
		
		String state =faker.address().state();
		
		
		CustomerAddress customeraddress= new CustomerAddress(flatno, apartmentname, streename, landmark, area, zipcode, Country, state);
		System.out.println(customeraddress);
		return customeraddress;
	}

	private static Customer generateFakeCustomerData(){
		String fname = faker.name().firstName();
		String lname = faker.name().lastName();
		String mobilenumber =faker.numerify("98########");
		String altmobilenumber =faker.numerify("98########");
		String emailid =faker.internet().emailAddress();
		String altemailid =faker.internet().emailAddress();
		
		Customer customer = new Customer(fname, lname, mobilenumber, altmobilenumber, emailid, altemailid);
		System.out.println(customer);
		return customer;
		
	}
}
