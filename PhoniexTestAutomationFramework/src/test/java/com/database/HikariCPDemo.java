package com.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.api.utils.ConfigManager2;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPDemo {

	public static void main(String[] args) throws SQLException, IOException {
		HikariConfig hikariconfig = new HikariConfig();
		hikariconfig.setJdbcUrl(ConfigManager2.getproperty("DB_URL"));
		hikariconfig.setUsername(ConfigManager2.getproperty("DB_USER_NAME"));
		hikariconfig.setPassword(ConfigManager2.getproperty("DB_PASSWORD"));
		
		hikariconfig.setMaximumPoolSize(10);
		hikariconfig.setMinimumIdle(2);
		hikariconfig.setConnectionTimeout(10000);
		hikariconfig.setIdleTimeout(10000);
		hikariconfig.setMaxLifetime(1800000);
		hikariconfig.setPoolName("test automation pool");
		
		HikariDataSource ds = new HikariDataSource(hikariconfig);
		Connection conn =ds.getConnection();
		System.out.println(conn);
		
		Statement statmt = conn.createStatement();
		
		ResultSet rs =statmt.executeQuery("select first_name ,last_name ,mobile_number  from tr_customer ;");
                while(rs.next()) {
                	System.out.println(
                		    rs.getString("first_name") + "|" +
                		    rs.getString("last_name") + "|" +
                		    rs.getString("mobile_number")
                		);
                }
                ds.close();
	}
	

}
