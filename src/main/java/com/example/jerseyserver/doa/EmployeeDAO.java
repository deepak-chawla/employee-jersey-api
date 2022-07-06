package com.example.jerseyserver.doa;

import java.util.List;

import com.example.jerseyserver.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;

public class EmployeeDAO {


    public List<Employee> getEmployees(){
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("from Employee");
        List<Employee> employees =  query.list();
        session.close();
        return employees;
    }

}
