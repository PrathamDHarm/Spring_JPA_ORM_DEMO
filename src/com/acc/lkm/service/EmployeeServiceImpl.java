package com.acc.lkm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.lkm.businessbean.EmployeeBean;
import com.acc.lkm.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeServices {
	@Autowired
	private EmployeeDAO employeeDao;
	@Override
	public Integer addEmployee(EmployeeBean employeeBean) throws Exception {
		
		return employeeDao.addEmployee(employeeBean);
	}

	@Override
	public EmployeeBean getEmployeeDetails(Integer id) throws Exception {
		EmployeeBean emp=employeeDao.getEmployeeDetails(id);
		return emp;
	}

	 @Override
	    public void deleteEmployee(String name) throws Exception {
	       
	         employeeDao.deleteEmployee(name);
	    }

	@Override
	public void updateEmployee(EmployeeBean employeeBean) throws Exception {
		// TODO Auto-generated method stub
		
	}


	

}
