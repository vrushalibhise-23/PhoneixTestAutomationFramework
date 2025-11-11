package com.dataprovider;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.api.utils.CSVReadUtility;
import com.dataprovider.beans.UserBean;

public class DataProviderUtils {
	
	@DataProvider(name="loginAPIDataProvider",parallel=true)
	public static Iterator<UserBean> loginAPIDataProvider() {
		return CSVReadUtility.loadCSV("testData/LoginCreds.csv");
	}

}
