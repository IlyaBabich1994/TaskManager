package net.taskmanager.Repos;

import net.taskmanager.Task.Tasks;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TasksRepoImpl implements TasksRepo{
    private static final Logger login = LoggerFactory.getLogger(TasksRepoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTask(Tasks task) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(task);
    }

    @Override
    public void editTask(Tasks task) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(task);
    }

    @Override
    public void removeTask(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tasks task = (Tasks) session.load(Tasks.class, new Integer(id));
        if(task != null)
        session.delete(task);
    }

    @Override
    public Tasks getTaskById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Tasks task = (Tasks) session.load(Tasks.class, new Integer(id));
        return task;
    }

    @Override
    @SuppressWarnings("uncheked")
    public List<Tasks> listTask() {
        return null;
    }
}
