package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.dataprovider.beans.UserBean;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReadUtility {
	private CSVReadUtility() {

	}

	public static Iterator<UserBean> loadCSV(String pathtoCSVfile) {

		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathtoCSVfile);
		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvreader = new CSVReader(isr);

		CsvToBean<UserBean> csvbean = new CsvToBeanBuilder(csvreader)
				.withType(UserBean.class)
				.withIgnoreEmptyLine(true)
				.build();

		List<UserBean> userlist = csvbean.parse();
		return userlist.iterator();
	}

}
