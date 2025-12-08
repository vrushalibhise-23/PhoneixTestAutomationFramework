package com.database;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseRunner {

	public static void main(String[] args) throws SQLException, IOException {
		DataBaseManager.createConnection();
		DataBaseManager.createConnection();


	}

}
