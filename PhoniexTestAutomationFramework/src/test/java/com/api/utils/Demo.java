package com.api.utils;
import java.util.Iterator;
import com.api.utils.CSVReadUtility;
import com.dataprovider.beans.CreateJobBean;

public class Demo {

    public static void main(String[] args) {

        Iterator<CreateJobBean> iterator = 
                CSVReadUtility.loadCSV("testData/CreateJobData.csv", CreateJobBean.class);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
