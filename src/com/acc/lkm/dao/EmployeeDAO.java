package com.acc.lkm.dao;

import com.acc.lkm.businessbean.EmployeeBean;

public interface EmployeeDAO {
	
	EmployeeBean getEmployeeDetails(Integer id) throws Exception;
	Integer addEmployee(EmployeeBean employeeBean) throws Exception;
	
	void deleteEmployee(String name) throws Exception;
}
