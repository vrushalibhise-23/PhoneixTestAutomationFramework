package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
	
	private static Properties prop = new Properties();
	
	private ConfigManager() {
		
	}
	static {
		File configFile = new File(
			    "C:" + File.separator + "Users" + File.separator + "Amol" + File.separator +
			    "git" + File.separator + "repository" + File.separator +
			    "PhoniexTestAutomationFramework" + File.separator +
			    "src" + File.separator + "test" + File.separator +
			    "resources" + File.separator + "config" + File.separator +
			    "config.properties"
			);
	    
		
		FileReader filereader = null;
		try {
			filereader = new FileReader(configFile);
			prop.load(filereader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getproperty(String key) throws IOException {
	
	
	
	
	
	return prop.getProperty("BASE_URI");
	
	
	
	
}

	
}
