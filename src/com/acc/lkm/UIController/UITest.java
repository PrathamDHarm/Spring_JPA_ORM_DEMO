package com.acc.lkm.UIController;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acc.lkm.businessbean.EmployeeBean;
import com.acc.lkm.service.EmployeeServices;

@SuppressWarnings("res")
public class UITest {

    public static void main(String[] args) {
        EmployeeServices employeeService = null;
        try {
            ApplicationContext ac = new ClassPathXmlApplicationContext("/com/acc/lkm/resources/cst_main_config.xml");
            employeeService = (EmployeeServices) ac.getBean("employeeServiceImpl");
            
//            addEmployee(employeeService); 
//            getEmployeeDetails(employeeService); 
            deleteEmployee(employeeService); 
            
        } catch (Exception ex) {
            System.out.println("UITest Exception: " + ex);
        }
    }

    
    private static void addEmployee(EmployeeServices employeeService) {
        EmployeeBean bean = new EmployeeBean();
        bean.setName("Dharmendra");
        bean.setRole("ROS-Developer");
        bean.setSalary(100000.00);
        bean.setInsert_time(new Date());
        try {
            int id = employeeService.addEmployee(bean);
            System.out.println("Employee Details Registered with ID: " + id);
        } catch (Exception ex) {
            System.out.println("Error adding employee: " + ex.getMessage());
        }
    }
    private static void getEmployeeDetails(EmployeeServices employeeService) {
        try {
            EmployeeBean employeeBean = employeeService.getEmployeeDetails(4);
            if (employeeBean == null) {
                System.out.println("Invalid Employee ID");
            } else {
                System.out.println("Employee Details:");
                System.out.println("Employee Name is:" + employeeBean.getName());
                System.out.println("Salary is:" + employeeBean.getSalary());
                System.out.println("Role is:" + employeeBean.getRole());
            }
        } catch (Exception ex) {
            System.out.println("Error fetching employee details: " + ex.getMessage());
        }
    }

   

    private static void deleteEmployee(EmployeeServices employeeService) {
        String employeeName = "Pratham";
        try {
            employeeService.deleteEmployee(employeeName);
            System.out.println("Employee " + employeeName + " deleted successfully.");
        } catch (Exception ex) {
            System.out.println("Error deleting employee: " + ex.getMessage());
        }
    }
}
