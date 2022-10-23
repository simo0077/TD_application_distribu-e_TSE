package org.tse.td1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tse.td1.domain.Task;
import org.tse.td1.domain.TaskStatus;
import org.tse.td1.repositories.TaskRepo;
import org.tse.td1.repositories.TaskStatusRepo;
import org.tse.td1.servicesI.TaskServiceI;

import java.util.Collection;
import java.util.Optional;

@Component
public class TaskService implements TaskServiceI {
    @Autowired
    TaskRepo taskRepo;

    @Autowired
    TaskStatusRepo taskStatusRepo;

    @Override
    public Collection<Task> findAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public Task findTask(Long id) {

        return taskRepo.findById(id).orElse(null);

    }

    @Override
    public Task moveRightTask(Task task) {
        TaskStatus currentStatus = task.getTaskStatus();
        TaskStatus nextStatus = null;
        switch (currentStatus.getLabel()) {
            case "status 1":
                nextStatus = taskStatusRepo.findByLabel("status 2");
                break;
            case "status 2":
                nextStatus = taskStatusRepo.findByLabel("status 3");
                break;
            case "status 3":
                nextStatus = taskStatusRepo.findByLabel("status 4");
                break;
            case "status 4":
                nextStatus = currentStatus;
                break;
        }
        task.setTaskStatus(nextStatus);
        return task;
    }

    @Override
    public Task moveLeftTask(Task task) {
        TaskStatus currentStatus = task.getTaskStatus();
        TaskStatus previousStatus = null;
        switch (currentStatus.getLabel()) {
            case "status 1":
                previousStatus = currentStatus;
                break;
            case "status 2":
                previousStatus = taskStatusRepo.findByLabel("status 1");
                break;
            case "status 3":
                previousStatus = taskStatusRepo.findByLabel("status 2");
                break;
            case "status 4":
                previousStatus = taskStatusRepo.findByLabel("status 3");
                break;
        }
        task.setTaskStatus(previousStatus);
        return task;
    }
}
