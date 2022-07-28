package com.example.jerseyserver.doa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.jerseyserver.helper.SessionUtil;
import org.hibernate.query.Query;
import org.hibernate.Session;
import com.example.jerseyserver.entity.Task;


public class TaskDAO {

    public void updateTask(Task task) {
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        session.saveOrUpdate(task);
        session.getTransaction().commit();
        session.close();
    }

    public List<Task> getEmployeeTasks(int emp_id, String sDate, String eDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(sDate);
        Date endDate = sdf.parse(eDate);
        Session session = SessionUtil.getSession();
        Query<Task> query = session.createQuery("from Task where employee_employee_id = :emp_id and date between :startDate and :endDate", Task.class)
                .setParameter("emp_id",emp_id)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate);
        List<Task> tasks = query.list();
        session.close();
        return tasks;
    }

    public List<Task> getAllWeeklyTasks(String sDate, String eDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(sDate);
        Date endDate = sdf.parse(eDate);
        Session session = SessionUtil.getSession();
        Query<Task> query = session.createQuery("from Task where date between :startDate and :endDate", Task.class)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate);
        List<Task> tasks = query.list();
        session.close();
        return tasks;
    }

    public List<Task> getTasks() {
        Session session = SessionUtil.getSession();
        Query<Task> query = session.createQuery("from Task", Task.class);
        List<Task> tasks = query.list();
        session.close();
        return tasks;
    }
}
