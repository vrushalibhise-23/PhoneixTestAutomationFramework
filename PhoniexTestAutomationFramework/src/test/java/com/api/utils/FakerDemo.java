package com.api.utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale locale = new Locale("en-IND");
        Faker faker = new Faker(locale);
        String firstName=faker.name().firstName();
        String Lastname = faker.name().lastName();
        System.out.println(firstName);
        System.out.println(Lastname);
        
       String buildingnumber= faker.address().buildingNumber();
       System.out.println(buildingnumber);
       
       System.out.println(faker.address().streetAddress());
       
       System.out.println(faker.address().streetName());
       
      System.out.println( faker.address().cityName());
      
      System.out.println(faker.number().digit());
      
      System.out.println(faker.number().digits(3));
      
      System.out.println( faker.numerify("231#######"));
      
      System.out.println(faker.internet().emailAddress());
	}

}
