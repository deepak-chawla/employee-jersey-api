package com.example.jerseyserver.doa;

import java.util.List;
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

    public void createTask(Task task) {
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        session.save(task);
        session.getTransaction().commit();
        session.close();
    }

    public List<Task> getEmployeeTasks(int emp_id) {
        Session session = SessionUtil.getSession();
        Query<Task> query = session.createQuery("from Task where employee_employee_id = :emp_id", Task.class)
                .setParameter("emp_id", emp_id);
        List<Task> tasks = query.list();
        session.close();
        return tasks;
    }
}
