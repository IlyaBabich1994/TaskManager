package net.taskmanager.service;

import net.taskmanager.Repos.TasksRepo;
import net.taskmanager.Task.Tasks;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TasksServiceImpl implements TasksService {
    private TasksRepo tasksRepo;

    public void setTasksRepo(TasksRepo tasksRepo) {
        this.tasksRepo = tasksRepo;
    }

    @Override
    @Transactional
    public void addTask(Tasks task) {
        this.tasksRepo.addTask(task);
    }

    @Override
    @Transactional
    public void editTask(Tasks task) {
        this.tasksRepo.editTask(task);
    }

    @Override
    @Transactional
    public void removeTask(int id) {
        this.tasksRepo.removeTask(id);
    }

    @Override
    @Transactional
    public Tasks getTaskById(int id) {
        return this.tasksRepo.getTaskById(id);
    }

    @Override
    @Transactional
    public List<Tasks> listTask() {
        return this.tasksRepo.listTask();
    }
}
