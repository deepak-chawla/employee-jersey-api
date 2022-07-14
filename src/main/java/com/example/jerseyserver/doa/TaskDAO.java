package com.example.jerseyserver.doa;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import com.example.jerseyserver.entity.Task;


public class TaskDAO {
    public void createTask(Task task) {
        Session session = SessionUtil.getSession();
        session.beginTransaction();
        session.save(task);
        session.getTransaction().commit();
        session.close();
    }

    public List<Task> getEmployeeTasks(int emp_id) {
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("FROM Task WHERE employee_employee_id = :emp_id").setParameter("emp_id", emp_id);
        List<Task> tasks = query.list();
        session.close();
        return tasks;
    }
}
