package com.acc.lkm.service;

import com.acc.lkm.businessbean.EmployeeBean;

public interface EmployeeServices {
	Integer addEmployee(EmployeeBean employeeBean) throws Exception;
	EmployeeBean getEmployeeDetails(Integer id) throws Exception;
//	EmployeeBean deleteEmployee(Integer id) throws Exception;
	void deleteEmployee(String name) throws Exception;
	void updateEmployee(EmployeeBean employeeBean) throws Exception;

}
