package com.acc.lkm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;


import com.acc.lkm.businessbean.EmployeeBean;
import com.acc.lkm.entity.EmployeeEntity;

@Repository
@Transactional
public class EmployeeDAOIMPL implements EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Integer addEmployee(EmployeeBean employeeBean) throws Exception {
        EmployeeEntity employeeEntity = convertBeanToEntity(employeeBean);
        entityManager.persist(employeeEntity);
        return employeeEntity.getId();
    }

    @Override
    public EmployeeBean getEmployeeDetails(Integer id) throws Exception {
        EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, id);
        if (employeeEntity != null) {
            return convertEntityToBean(employeeEntity);
        }
        return null;
    }

   


    @Override
    public void deleteEmployee(String name) throws Exception {
       
        entityManager.createQuery("DELETE FROM EmployeeEntity e WHERE e.name = :name")
                     .setParameter("name", name)
                     .executeUpdate();
    }

    private EmployeeBean convertEntityToBean(EmployeeEntity employeeEntity) {
        EmployeeBean employee = new EmployeeBean();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    private EmployeeEntity convertBeanToEntity(EmployeeBean employeeBean) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeBean, employeeEntity);
        return employeeEntity;
    }
}
