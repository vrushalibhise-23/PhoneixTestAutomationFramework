package com.dataprovider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.UserCredentials;
import com.api.utils.CSVReadUtility;
import com.api.utils.CreateJobBeanMapper;
import com.api.utils.ExcelReaderUtil2;
import com.api.utils.FakerDataGenerator;
import com.api.utils.JSONReaderUtil;
import com.dataprovider.beans.CreateJobBean;
import com.dataprovider.beans.UserBean;

public class DataProviderUtils {
	
	@DataProvider(name="loginAPIDataProvider",parallel=true)
	public static Iterator<UserBean> loginAPIDataProvider() {
		return CSVReadUtility.loadCSV("testData/LoginCreds.csv", UserBean.class);
	}
	
	@DataProvider(name="CreateJobAPIDataProvider",parallel=true)
	public static Iterator<CreateJobPayload> CreateJobAPIDataProvider() {
		Iterator<CreateJobBean> createjob= 
				CSVReadUtility.loadCSV("testData/CreateJobData.csv", CreateJobBean.class);
		
		
		List<CreateJobPayload>payloadlist=new ArrayList<>();
		CreateJobBean tempBean;
		CreateJobPayload tempayload;
		
		while(createjob.hasNext()) {
			tempBean=createjob.next();
			tempayload = CreateJobBeanMapper.mapper(tempBean);
			payloadlist.add(tempayload);
			
		}
		return payloadlist.iterator();
		
	}
	
	@DataProvider(name="CreateJobFakerAPIDataProvider",parallel=true)
	public static Iterator<CreateJobPayload> CreateJobFakerAPIDataProvider() {
		//String fakerCount = System.getProperty("fakerCount",5);
		Iterator<CreateJobPayload> payloadIterator= FakerDataGenerator.generateFakeCreateJobData(100);
				
		return payloadIterator;
		
		
		
	}
	
	@DataProvider(name="LoginAPIJSONDataProvider",parallel=true)
	public static Iterator<UserCredentials> loginAPIJSONDataProvider() {
		return JSONReaderUtil.loadJson("testData/LoginAPIData.json", UserCredentials[].class);
	}
	
	
	@DataProvider(name="CreateJObAPIJSONDataProvider",parallel=true)
	public static Iterator<CreateJobPayload> CreateJobAPIJSONDataProvider() {
		return JSONReaderUtil.loadJson("testData/CreateJobAPIData.json",CreateJobPayload[].class);
	}
	
	
//	@DataProvider(name="LoginAPIExcelDataProvider",parallel=true)
//	public static Iterator<UserBean> loginAPIExcelDataProvider() throws IOException {
//		return ExcelReaderUtil2.loadTestData("LoginTestData",UserBean.class);
//	}
	

}
