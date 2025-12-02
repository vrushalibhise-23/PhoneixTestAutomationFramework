package com.api.tests.dataprovider;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.request.model.UserCredentials;
import static com.api.utils.SpecUtil.*;
import com.dataprovider.beans.UserBean;

public class LoginAPIJSONDataDrivenTest {
	
	@Test(description="Verify if login api is working for FD user", groups= {"smoke","regression","api"}
	,dataProviderClass=com.dataprovider.DataProviderUtils.class,
			dataProvider="LoginAPIJSONDataProvider")
	
	
	public void loginAPI(UserCredentials usercredentials) {
		try {
			given()
			.spec(requestSpec(usercredentials))	
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
