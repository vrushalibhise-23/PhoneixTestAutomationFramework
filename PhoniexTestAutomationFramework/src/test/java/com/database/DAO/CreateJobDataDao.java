package com.database.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.database.DataBaseManager;
import com.dataprovider.beans.CreateJobBean;

public class CreateJobDataDao {

	private static final  String query = """
		    SELECT 
	        mst_service_location_id,
	        mst_platform_id,
	        mst_warrenty_status_id,
	        mst_oem_id,
	        first_name,
	        last_name,
	        mobile_number,
	        mobile_number_alt,
	        email_id,
	        email_id_alt,
	        flat_number,
	        apartment_name,
	        street_name,
	        landmark,
	        area,
	        pincode,
	        country,
	        state,
	        mst_model_id,
	        dop,
	        popurl,
	        imei2,
	        imei1,
	        serial_number,
	        mst_problem_id,
	        remark
	    FROM tr_customer
	    INNER JOIN tr_customer_address 
	        ON tr_customer.id = tr_customer_address.id
	    INNER JOIN tr_customer_product 
	        ON tr_customer.id = tr_customer_product.tr_customer_id
	    INNER JOIN tr_job_head 
	        ON tr_customer.id = tr_job_head.tr_customer_id
	    INNER JOIN map_job_problem 
	        ON tr_customer.id = map_job_problem.tr_job_head_id
	    LIMIT 5;
	    """;
	
	public static List<CreateJobBean> getCReateJobPayloaddata() {
		Connection conn;
		Statement statement;
		ResultSet resultset;
		List<CreateJobBean> beanlist = new ArrayList<CreateJobBean>();
		
		try {
			 conn =DataBaseManager.getConnection();
			 statement =conn.createStatement();
			 resultset =statement.executeQuery(query);
			 while(resultset.next()) {
				 CreateJobBean createbean = new CreateJobBean() ;
				 createbean.setMst_service_location_id(resultset.getString("mst_service_location_id"));
				 createbean.setMst_platform_id(resultset.getString("mst_platform_id"));
				 createbean.setMst_warrenty_status_id(resultset.getString("mst_warrenty_status_id"));
				 createbean.setMst_oem_id(resultset.getString("1"));
				 createbean.setCustomer__first_name(resultset.getString("first_name"));
				 createbean.setCustomer__last_name(resultset.getString("last_name"));
				 createbean.setCustomer__mobile_number(resultset.getString("mobile_number"));
				 createbean.setCustomer__mobile_number_alt(resultset.getString("mobile_number_alt"));
				 createbean.setCustomer__email_id(resultset.getString("email_id"));
				 createbean.setCustomer__email_id_alt(resultset.getString("email_id_alt"));
				 createbean.setCustomer_address__flat_number(resultset.getString("flat_number"));
				 createbean.setCustomer_address__apartment_name(resultset.getString("apartment_name"));
				 createbean.setCustomer_address__street_name(resultset.getString("street_name"));
				 createbean.setCustomer_address__landmark(resultset.getString("landmark"));
				 createbean.setCustomer_address__area(resultset.getString("area"));
				 createbean.setCustomer_address__pincode(resultset.getString("pincode"));
				 createbean.setCustomer_address__country(resultset.getString("country"));
				 createbean.setCustomer_address__state(resultset.getString("state"));
				 createbean.setCustomer_product__dop(resultset.getString("dop"));
				 createbean.setCustomer_product__imei1(resultset.getString("imei1"));
				 createbean.setCustomer_product__imei2(resultset.getString("imei2"));
				 createbean.setCustomer_product__serial_number(resultset.getString("serial_number"));
				 createbean.setCustomer_product__popurl(resultset.getString("popurl"));
				 createbean.setCustomer_product__product_id("1");
				 createbean.setCustomer_product__mst_model_id(resultset.getString("1"));
				 createbean.setProblems__id(resultset.getString("mst_problem_id"));
				 createbean.setProblems__remark(resultset.getString("remark"));
				 beanlist.add(createbean);
				 
				 
				 
			 }
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(beanlist);
		 return beanlist;
	}
	
 
}
