package com.demo.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadSCSVFile {

	public static void main(String[] args) throws IOException, CsvException {
		
		InputStream is =Thread.currentThread().getContextClassLoader().getResourceAsStream("TestData/LoginCreds.csv");
		InputStreamReader isr = new InputStreamReader(is);
//		File file = new File("C:\\Users\\Amol\\git\\repository\\PhoniexTestAutomationFramework\\src\\main\\resources\\TestData\\LoginCreds.csv");
//		FileReader fr = new FileReader(file);
       CSVReader csvreader = new CSVReader(isr);
       
      List<String[]>datalist= csvreader.readAll();
      
      for(String[] dataArray:datalist) {
    	  System.out.println(dataArray[0]);
//    	  for(String data :dataArray) {
//    		  System.out.println(data +"");
//    	  }
      }
       
	}

}
