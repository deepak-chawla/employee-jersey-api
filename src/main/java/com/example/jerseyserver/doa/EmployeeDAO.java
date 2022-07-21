package com.example.jerseyserver.doa;

import java.util.List;

import com.example.jerseyserver.entity.Employee;
import com.example.jerseyserver.helper.SessionUtil;
import org.hibernate.query.Query;
import org.hibernate.Session;

public class EmployeeDAO {

    public List<Employee> getEmployees() {
        Session session = SessionUtil.getSession();
        Query<Employee> query = session.createQuery("from Employee",Employee.class);
        List<Employee> employees = query.list();
        session.close();
        return employees;
    }

    public void addEmployee(Employee employee) {
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
    }
}
