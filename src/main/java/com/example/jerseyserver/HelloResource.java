package com.example.jerseyserver;
import com.example.jerseyserver.controller.EmployeeController;
import com.example.jerseyserver.entity.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employee")
public class HelloResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(){
        return new Employee(1, 654, "Deepak");
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAccount(@Context HttpServletRequest request){
//        try {
//            EmployeeController controller = new EmployeeController();
//            return Response.ok().entity(controller.getAccountWashSales(getPrincipalUser(request).getFirm(), accountId, offset, limit, sort, filter, fields)).build();
//
//        } catch (Exception e) {
//            LOG.error("getAccountWashSales(...) Exception: "+e.getMessage(),e);
//            return Response.status(CommonResponsesCodes.BAD_REQUEST_CODE).build();
//        }
//    }
}