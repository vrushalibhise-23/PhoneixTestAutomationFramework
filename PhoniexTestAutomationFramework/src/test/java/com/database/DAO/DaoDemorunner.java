package com.database.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.api.request.model.CreateJobPayload;
import com.api.utils.CreateJobBeanMapper;
import com.database.DataBaseManager;
import com.dataprovider.beans.CreateJobBean;
import com.db.model.CustomerDBModel;

public class DaoDemorunner {

	public static void main(String[] args) throws SQLException, IOException {// TODO Auto-generated method stub
		 DataBaseManager.intializePool();
		 CustomerDao.getCustomerInfo();
		 
		 CustomerDBModel cutsomerdbdata = CustomerDao.getCustomerInfo();
		 System.out.println(cutsomerdbdata);
		//CreateJobDataDao.getCReateJobPayloaddata();
		 
//		 List<CreateJobBean> beanList =CreateJobDataDao.getCReateJobPayloaddata();
//		 List<CreateJobPayload> payloadList = new ArrayList<CreateJobPayload>();
//		 
//		 for(CreateJobBean bean:beanList) {
//			 CreateJobPayload payload = CreateJobBeanMapper.mapper(bean);
//			 payloadList.add(payload);
//		 }
//		 
//		 for(CreateJobPayload payload:payloadList) {
//			 System.out.println(payload);
//		 }
}

}
