package net.taskmanager.controller;

import net.taskmanager.Task.Tasks;
import net.taskmanager.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TasksController {
    private TasksService tasksService;

    @Autowired(required = true)
    @Qualifier(value = "TasksService")
    public void setTasksService(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @RequestMapping(value = "task", method = RequestMethod.GET)
    public String listTask(Model model){
        model.addAttribute("task", new Tasks());
        model.addAttribute("listTask", this.tasksService.listTask());

        return "task";
    }

    @RequestMapping(value = "/task/add", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("task") Tasks task){
        if(task.getId() == 0){
            this.tasksService.addTask(task);
        }else {
            this.tasksService.editTask(task);
        }

        return "redirect:/task";
    }

    @RequestMapping("/remove/{id}")
    public String removeTask(@PathVariable("id") int id){
        this.tasksService.removeTask(id);

        return "redirect:/task";
    }

    @RequestMapping("edit/{id}")
    public String editTask(@PathVariable("id") int id, Model model){
        model.addAttribute("book", this.tasksService.getTaskById(id));
        model.addAttribute("listBooks", this.tasksService.listTask());

        return "tasks";
    }

    @RequestMapping("taskdata/{id}")
    public String taskData(@PathVariable("id") int id, Model model){
        model.addAttribute("task", this.tasksService.getTaskById(id));

        return "taskdata";
    }
}
