package org.tse.td1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tse.td1.domain.Task;
import org.tse.td1.services.TaskService;
import org.tse.td1.utilities.Label;

import java.util.Collection;
import java.util.List;


@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public Collection<Task> getTasks(){
        return taskService.findAllTasks();
    }

    @PostMapping("/tasks")
    public Task postTask(@RequestBody Task task) {
        return   taskService.addTask(task);
    }

    @PatchMapping("/tasks/{id}")
    public Task moveTaskLeftOrRight(@PathVariable Long id,@RequestBody Label label){
        if (label.label.equals("left")){
            return taskService.moveLeftTask(taskService.findTask(id));
        }
        else if (label.label.equals("right")){
            return taskService.moveRightTask(taskService.findTask(id));
        }
        else {
            return null;
        }

    }
}



