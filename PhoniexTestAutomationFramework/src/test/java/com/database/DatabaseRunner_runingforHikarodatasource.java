package com.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseRunner_runingforHikarodatasource {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub
        DataBaseManager.intializePool();
       Connection conn= DataBaseManager.getConnection();
       System.out.println(conn);

	}

}
