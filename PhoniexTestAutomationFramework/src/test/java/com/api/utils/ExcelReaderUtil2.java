package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.api.request.model.UserCredentials;
import com.dataprovider.beans.UserBean;
import com.poiji.bind.Poiji;

public class ExcelReaderUtil2 {

	public static Iterator<UserBean> loadTestData(String sheetname,Class<UserBean> class1) throws IOException {
		
		InputStream is = Thread.currentThread().getContextClassLoader().
				getResourceAsStream("testData/PhoneixTestData.xlsx");
	
         XSSFWorkbook workbook = new XSSFWorkbook(is);
         
        XSSFSheet mysheet = workbook.getSheet(sheetname);
        
      List<UserBean> datalist= Poiji.fromExcel(mysheet, UserBean.class);
	 return datalist.iterator();
        
	}
}
