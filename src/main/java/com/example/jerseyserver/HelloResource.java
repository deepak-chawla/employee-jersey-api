package com.example.jerseyserver;

import com.example.jerseyserver.doa.EmployeeDAO;
import com.example.jerseyserver.entity.Employee;
import javax.ws.rs.*;
import java.util.List;


@Path("/employee")
public class HelloResource {

    @GET
    @Produces("application/json")
    public List<Employee> getEmployee() {
        EmployeeDAO dao = new EmployeeDAO();
        List employees = dao.getEmployees();
        return employees;
    }

}