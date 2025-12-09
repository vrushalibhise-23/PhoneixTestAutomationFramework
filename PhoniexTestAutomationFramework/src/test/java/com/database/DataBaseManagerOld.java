package com.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.api.utils.ConfigManager;
import com.api.utils.ConfigManager2;

public class DataBaseManagerOld {

	private static volatile Connection conn;
	
      private DataBaseManagerOld() {
    	  
      }
	    public synchronized static void createConnection() throws SQLException, IOException {
	        final String DB_URL = ConfigManager2.getproperty("DB_URL");
	        
	        final String DB_USERNAME = ConfigManager2.getproperty("DB_USER_NAME");
	        final String DB_PASSWORD = ConfigManager2.getproperty("DB_PASSWORD");
	        
	        if(conn==null) {
	        	synchronized(DataBaseManagerOld.class) {
            if(conn==null) {
	         conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	        System.out.println(conn);

	      //  conn.close();
	}
	    }
	    }
}
}

