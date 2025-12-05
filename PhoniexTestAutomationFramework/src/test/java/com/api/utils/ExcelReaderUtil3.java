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
import com.dataprovider.beans.CreateJobBean;
import com.dataprovider.beans.UserBean;
import com.poiji.bind.Poiji;

public class ExcelReaderUtil3 {

	public static void main(String[] args) throws IOException {
		Iterator<CreateJobBean> iterator =ExcelReaderUtil2.loadTestData("testData/PhoneixTestData.xlsx", "CreateJobTestData",CreateJobBean.class);
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
        
	}
}
