package com.example.jerseyserver.services;

import com.example.jerseyserver.doa.EmployeeDAO;
import com.example.jerseyserver.entity.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employee")
public class EmployeeServices {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee() {
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> employees = dao.getEmployees();
        return Response.ok().entity(employees).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEmployee(Employee emp) {
        emp.setCode(emp.getCode());
        emp.setName(emp.getName());
        EmployeeDAO dao = new EmployeeDAO();
        dao.addEmployee(emp);
        return Response.ok().entity("Successfully Created.").build();
    }

}