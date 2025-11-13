package com.api.tests.dataprovider;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.request.model.UserCredentials;
import static com.api.utils.SpecUtil.*;
import com.dataprovider.beans.UserBean;

public class LoginAPIDataDrivenTest {
	
	@Test(description="Verify if login api is working for FD user", groups= {"smoke","regression","api"}
	,dataProviderClass=com.dataprovider.DataProviderUtils.class,
			dataProvider="loginAPIDataProvider")
	
	
	public void loginAPI(UserBean userbean) {
		try {
			given()
			.spec(requestSpec(userbean))	
			.when()
			.log().all()
			.post("/login")
			.then()
			.spec(responseSpecification())

      ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
