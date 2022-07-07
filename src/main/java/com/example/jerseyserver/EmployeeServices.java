package com.example.jerseyserver;

import com.example.jerseyserver.doa.EmployeeDAO;
import com.example.jerseyserver.entity.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/employee")
public class EmployeeServices {
    @GET
    @Produces("application/json")
    public Response getEmployee(){
        EmployeeDAO dao = new EmployeeDAO();
        List<Employee> employees = dao.getEmployees();
        return Response.ok().entity(employees).header("Access-Control-Allow-Origin", "*").build();
    }

}