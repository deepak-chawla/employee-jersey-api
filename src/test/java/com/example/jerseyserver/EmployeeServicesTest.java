package com.example.jerseyserver;

import com.example.jerseyserver.doa.EmployeeDAO;
import com.example.jerseyserver.entity.Employee;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServicesTest {

    @Test
    public void shouldReturnListOfEmployee(){
        EmployeeServices employeeDAO = new EmployeeServices();
        List<Employee> employees = new ArrayList();
        assertEquals(employees,employeeDAO.getEmployee());
    }

}