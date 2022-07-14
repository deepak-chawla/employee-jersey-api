package com.example.jerseyserver;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.jerseyserver.doa.TaskDAO;
import com.example.jerseyserver.entity.Task;

@Path("/task")
public class TaskServices {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTask(Task task){
        task.setTaskName(task.getTaskName());
        task.setDate(new Date());
        task.setEmployee(task.getEmployee());
        TaskDAO dao = new TaskDAO();
        dao.createTask(task);
        return Response.status(201).entity("Task Successfully Created.").header("Access-Control-Allow-Origin", "*").build();
    }


    @Path("/{emp_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEmployeeTasks(@PathParam("emp_id") int emp_id){
        TaskDAO taskdao = new TaskDAO();
        List<Task> tasks = taskdao.getEmployeeTasks(emp_id);
        return Response.ok().entity(tasks).header("Access-Control-Allow-Origin", "*").build();
    }
    

}
