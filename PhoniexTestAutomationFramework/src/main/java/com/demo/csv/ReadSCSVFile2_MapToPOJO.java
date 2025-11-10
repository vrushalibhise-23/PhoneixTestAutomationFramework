package com.demo.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;

public class ReadSCSVFile2_MapToPOJO {

	public static void main(String[] args) throws IOException, CsvException {
		
		
		InputStream is =Thread.currentThread().getContextClassLoader().getResourceAsStream("TestData/LoginCreds.csv");
		InputStreamReader isr = new InputStreamReader(is);
        CSVReader csvreader = new CSVReader(isr);
        
        CsvToBean<UserBean> csvbean = new CsvToBeanBuilder(csvreader)
        		.withType(UserBean.class)
        		.withIgnoreEmptyLine(true)
        		.build();

        
        List<UserBean> userlist = csvbean.parse();
        System.out.println(userlist);
}
}
