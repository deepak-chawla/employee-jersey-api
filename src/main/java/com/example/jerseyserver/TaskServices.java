package com.example.jerseyserver;

import java.util.Date;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.jerseyserver.doa.TaskDAO;
import com.example.jerseyserver.entity.Task;

@Path("/task")
public class TaskServices {
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTask(Task task){
        task.setTaskName(task.getTaskName());
        task.setSunday(task.getSunday());
        task.setMonday(task.getMonday());
        task.setTuesday(task.getTuesday());
        task.setWednesday(task.getWednesday());
        task.setThursday(task.getThursday());
        task.setFriday(task.getFriday());
        task.setSaturday(task.getSaturday());
        task.setDate(task.getDate());
        task.setEmployee(task.getEmployee());
        TaskDAO dao = new TaskDAO();
        dao.updateTask(task);
        return Response.ok().entity(task).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTask(Task task){
        task.setTaskName(task.getTaskName());
        task.setSunday(task.getSunday());
        task.setMonday(task.getMonday());
        task.setTuesday(task.getTuesday());
        task.setWednesday(task.getWednesday());
        task.setThursday(task.getThursday());
        task.setFriday(task.getFriday());
        task.setSaturday(task.getSaturday());
        task.setDate(new Date());
        task.setEmployee(task.getEmployee());
        TaskDAO dao = new TaskDAO();
        dao.createTask(task);
        return Response.status(201).entity("Task Successfully Created.").build();
    }

    @Path("/{emp_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEmployeeTasks(@PathParam("emp_id") int emp_id){
        TaskDAO taskdao = new TaskDAO();
        List<Task> tasks = taskdao.getEmployeeTasks(emp_id);
        return Response.ok().entity(tasks).build();
    }

}
