package com.api.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderUtil {

	public static void main(String[] args) throws IOException {
		
		InputStream is = Thread.currentThread().getContextClassLoader().
				getResourceAsStream("testData/PhoneixTestData.xlsx");
	
         XSSFWorkbook workbook = new XSSFWorkbook(is);
         
        XSSFSheet mysheet = workbook.getSheet("LoginTestData");
        
        XSSFRow myrow ;
        
        XSSFCell mycell ;
        
       int lastWordIndex= mysheet.getLastRowNum();
       
       System.out.println(lastWordIndex);
       
       XSSFRow rowheader= mysheet.getRow(0);
       int lastIndexOfCol =rowheader.getLastCellNum()-1;
       System.out.println(lastIndexOfCol);
       
       for(int rowIndex=0;rowIndex<=lastIndexOfCol;rowIndex++) {
    	   for(int colIndex=0;colIndex<=lastIndexOfCol;colIndex++) {
    		   myrow =mysheet.getRow(rowIndex);
    		   mycell = myrow.getCell(colIndex);
    		   System.out.println(mycell +" ");
    		   
    		   
    	   }
    	   System.out.println(" ");
       }
        
        
	}

}
