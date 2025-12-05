package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.api.request.model.UserCredentials;

public class ExcelReaderUtil2 {

	public static Iterator<UserCredentials> loadTestData() throws IOException {
		
		InputStream is = Thread.currentThread().getContextClassLoader().
				getResourceAsStream("testData/PhoneixTestData.xlsx");
	
         XSSFWorkbook workbook = new XSSFWorkbook(is);
         
        XSSFSheet mysheet = workbook.getSheet("LoginTestData");
        
        XSSFRow myrow ;
        
        XSSFCell mycell ;
        
        XSSFRow headerrows =mysheet.getRow(0);
        
        int usernameIndex=-1;
        int passwordindex=-1;
        
        for(Cell cell:headerrows) {
        	if(cell.getStringCellValue().trim().equalsIgnoreCase("username")) {
        		usernameIndex= cell.getColumnIndex();
        	}
        	if(cell.getStringCellValue().trim().equalsIgnoreCase("password")) {
        		passwordindex= cell.getColumnIndex();
        }
        
	}
        System.out.println(usernameIndex+ " "+passwordindex);
        
        int lastrowIndex =mysheet.getLastRowNum();
        XSSFRow rowData;
        UserCredentials usercredentials;
        ArrayList<UserCredentials> userlist = new ArrayList<UserCredentials>();
        for(int rowIndex=1;rowIndex<=lastrowIndex;rowIndex++) {
        	 rowData=mysheet.getRow(rowIndex);
        	 usercredentials = new UserCredentials(rowData.getCell(usernameIndex).toString(),rowData.getCell(passwordindex).toString());
        	// System.out.println(userlist.iterator());
        	 userlist.add(usercredentials); 
        }
        
            return userlist.iterator();
}
}
