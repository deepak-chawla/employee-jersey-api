package com.example.jerseyserver.services;

import java.text.ParseException;
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
    public Response updateTask(List<Task> tasks){
        for (Task task: tasks) {
            task.setTid(task.getTid());
            TaskDAO dao = new TaskDAO();
            dao.updateTask(task);
        }
        return Response.ok().entity(tasks).build();
    }

    @Path("/{emp_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getEmployeeTasks(@PathParam("emp_id") int emp_id,
                                     @QueryParam("startDate") String sDate,
                                     @QueryParam("endDate") String eDate) throws ParseException {
        TaskDAO taskdao = new TaskDAO();
        List<Task> tasks = taskdao.getEmployeeTasks(emp_id ,sDate,eDate);
        return Response.ok().entity(tasks).build();
    }

    @Path("/weekly")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWeeklyTasks(@QueryParam("startDate") String sDate,
                                   @QueryParam("endDate") String eDate) throws ParseException {
        TaskDAO dao = new TaskDAO();
        List<Task> tasks = dao.getAllWeeklyTasks(sDate,eDate);
        return Response.ok().entity(tasks).build();
    }


    @Path("/tasks")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTasks() {
        TaskDAO dao = new TaskDAO();
        List<Task> tasks = dao.getTasks();
        return Response.ok().entity(tasks).build();
    }

}
