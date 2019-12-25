package net.taskmanager.Repos;

import net.taskmanager.Task.Tasks;

import java.util.List;

public interface TasksRepo {
    public void addTask(Tasks task);
    public void editTask(Tasks task);
    public void removeTask(int id);
    public Tasks getTaskById(int id);
    public List<Tasks> listTask();
}
