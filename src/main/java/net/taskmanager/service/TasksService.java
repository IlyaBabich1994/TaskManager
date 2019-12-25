package net.taskmanager.service;

import net.taskmanager.Task.Tasks;

import java.util.List;

public interface TasksService {
    public void addTask(Tasks task);
    public void editTask(Tasks task);
    public void removeTask(int id);
    public Tasks getTaskById(int id);
    public List<Tasks> listTask();
}
