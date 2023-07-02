package com.hludov.spring.mvc_hibernate_aop.dao;

import com.hludov.spring.mvc_hibernate_aop.entity.Employee;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    @Override
    public List<Employee> getAllEmployees() {
        Session session=sessionFactory.getCurrentSession();


        Query<Employee> query = session.createQuery("FROM Employee ", Employee.class);

        List<Employee> resultList = query.getResultList();

        return  resultList;


    }



}
