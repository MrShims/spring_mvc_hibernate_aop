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


    @Override
    public List<Employee> getAllEmployees() {
        Session session=sessionFactory.getCurrentSession();


        Query<Employee> query = session.createQuery("FROM Employee ", Employee.class);

        List<Employee> resultList = query.getResultList();

        return  resultList;


    }

    @Override
    public void saveEmployee(Employee employee) {

        Session session=sessionFactory.getCurrentSession();


        session.saveOrUpdate(employee);


    }

    @Override
    public Employee getEmployee(int id) {
        Session session=sessionFactory.getCurrentSession();
        return session.get(Employee.class,id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session=sessionFactory.getCurrentSession();
        Query query= session.createQuery("delete from Employee where id=:employeeId");

        query.setParameter("employeeId",id);

        query.executeUpdate();
    }


}
