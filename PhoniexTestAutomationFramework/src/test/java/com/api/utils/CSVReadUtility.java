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

	public static <T> Iterator<T> loadCSV(String pathtoCSVfile,Class <T> bean) {

		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathtoCSVfile);
		InputStreamReader isr = new InputStreamReader(is);
		CSVReader csvreader = new CSVReader(isr);

		CsvToBean<T> csvbean = new CsvToBeanBuilder(csvreader)
				.withType(bean)
				.withIgnoreEmptyLine(true)
				.build();

		List<T> list = csvbean.parse();
		return list.iterator();
	}

}
