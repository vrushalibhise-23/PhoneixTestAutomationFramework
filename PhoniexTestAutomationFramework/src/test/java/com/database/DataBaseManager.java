package com.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.api.utils.ConfigManager;
import com.api.utils.ConfigManager2;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataBaseManager {
	
    private static volatile HikariDataSource hikaridatasource;
	
	
	
      private DataBaseManager() {
    	  
      }
      
	    public  static void intializePool() throws SQLException, IOException {
	        final String DB_URL = ConfigManager2.getproperty("DB_URL");
	        
	        final String DB_USERNAME = ConfigManager2.getproperty("DB_USER_NAME");
	        final String DB_PASSWORD = ConfigManager2.getproperty("DB_PASSWORD");
	        final int MAXIMUM_POOL_SIZE =Integer.parseInt(ConfigManager2.getproperty("MAXIMUM_POOL_SIZE"));
	        final int MAXIMUM_IDLE_COUNT =Integer.parseInt(ConfigManager2.getproperty("MAXIMUM_IDLE_COUNT"));
	        final int CONNECTION_TIMEOUT_IN_SECONDS =Integer.parseInt(ConfigManager2.getproperty("CONNECTION_TIMEOUT_IN_SECONDS"));
	        final int IDLE_TIMEOUT_SECS =Integer.parseInt(ConfigManager2.getproperty("IDLE_TIMEOUT_SECS"));
	        final int MAX_LIFE_TIME_IN_MINS =Integer.parseInt(ConfigManager2.getproperty("MAX_LIFE_TIME_IN_MINS"));
	        final String HIKARI_CP_POOL_NAME =ConfigManager2.getproperty("HIKARI_CP_POOL_NAME");
	        
	        if(hikaridatasource==null) {
	        	synchronized(DataBaseManager.class) {
            if(hikaridatasource==null) {
            	HikariConfig hikariconfig = new HikariConfig();
            	hikariconfig.setJdbcUrl(DB_URL);
            	hikariconfig.setUsername(DB_USERNAME);
            	hikariconfig.setPassword(DB_PASSWORD);
        		
        		hikariconfig.setMaximumPoolSize(MAXIMUM_POOL_SIZE);
        		hikariconfig.setMinimumIdle(MAXIMUM_IDLE_COUNT);
        		hikariconfig.setConnectionTimeout(CONNECTION_TIMEOUT_IN_SECONDS*1000);
        		hikariconfig.setIdleTimeout(IDLE_TIMEOUT_SECS* 1000);
        		hikariconfig.setMaxLifetime(MAX_LIFE_TIME_IN_MINS * 60 * 1000);
        		hikariconfig.setPoolName(HIKARI_CP_POOL_NAME);
        		
        		hikaridatasource = new HikariDataSource(hikariconfig);

	      //  conn.close();
	}
	    }
	    }
}
	    public static Connection getConnection() {
	    
				Connection connection = null;
				try {
					connection = hikaridatasource.getConnection();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return connection;
			
	    }
}

