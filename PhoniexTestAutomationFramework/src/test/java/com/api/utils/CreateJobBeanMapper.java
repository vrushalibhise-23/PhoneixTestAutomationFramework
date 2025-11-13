package com.api.utils;

import java.util.ArrayList;
import java.util.List;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.CustomerAddress;
import com.api.request.model.CustomerProduct;
import com.api.request.model.Problems;
import com.dataprovider.beans.CreateJobBean;

public class CreateJobBeanMapper {

	
	private CreateJobBeanMapper() {

	}
	
	public static CreateJobPayload mapper(CreateJobBean bean) {
		
		int mstervicelocation =Integer.parseInt(bean.getMst_service_location_id());
		int mstplatformid =Integer.parseInt(bean.getMst_platform_id());
		int mstoemid =Integer.parseInt(bean.getMst_oem_id());
		int mstwarrantystatusid =Integer.parseInt(bean.getMst_warrenty_status_id());
		
		int productid =Integer.parseInt(bean.getCustomer_product__product_id());
		int mst_model_id =Integer.parseInt(bean.getCustomer_product__mst_model_id());
		
		CustomerProduct customerproduct = new CustomerProduct(bean.getCustomer_product__dop(),
				bean.getCustomer_product__serial_number(), 
				bean.getCustomer_product__imei1(),
				bean.getCustomer_product__imei2(), 
				bean.getCustomer_product__popurl(), productid, mst_model_id);
		
		CustomerAddress customeraddress = new CustomerAddress(bean.getCustomer_address__flat_number(), 
				bean.getCustomer_address__apartment_name(), 
				bean.getCustomer_address__street_name(), 
				bean.getCustomer_address__landmark(), 
				bean.getCustomer_address__area(),
				bean.getCustomer_address__pincode(), 
				bean.getCustomer_address__country(),
				bean.getCustomer_address__state());
		
		Customer customer = new Customer(bean.getCustomer__first_name(),
				bean.getCustomer__last_name(), 
				bean.getCustomer__mobile_number(), 
                bean.getCustomer__mobile_number_alt(), 
                bean.getCustomer__email_id(), 
                bean.getCustomer__email_id_alt());
		
		List<Problems> problemlist= new ArrayList<Problems>();
		int problemsid =Integer.parseInt(bean.getProblems__id());
		
		Problems problem = new Problems(problemsid, bean.getProblems__remark());
		problemlist.add(problem);
		
		CreateJobPayload payload = new CreateJobPayload(mstervicelocation, mstplatformid, mstwarrantystatusid,mstoemid, customer, customeraddress, customerproduct, problemlist);
	      return payload ;
	}

}
