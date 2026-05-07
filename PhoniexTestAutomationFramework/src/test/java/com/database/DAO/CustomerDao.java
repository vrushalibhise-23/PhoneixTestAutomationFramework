package com.database.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.database.DataBaseManager;
import com.db.model.CustomerDBModel;

public class CustomerDao {

	public static final String CUSTOMER_DETAIL_QUERY = """
	        SELECT * from tr_customer where id=274092
	        """;
	public static CustomerDBModel getCustomerInfo() throws SQLException {
		Connection conn = DataBaseManager.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet resultset = stmt.executeQuery(CUSTOMER_DETAIL_QUERY);
		CustomerDBModel customerdbmodel = null;
	    while(resultset.next()){
	    	System.out.println(resultset.getString("first_name"));
	    	System.out.println(resultset.getString("email_id"));
	    	
	    	
	    	customerdbmodel = new CustomerDBModel(resultset.getString("first_name"),
	    			resultset.getString("last_name"),
	    			resultset.getString("mobile_number"),
	    			resultset.getString("mobile_number_alt"),
	    			resultset.getString("email_id"),
	    			resultset.getString("email_id_alt"));
	    }
	    return customerdbmodel;
		
	}
			
}
