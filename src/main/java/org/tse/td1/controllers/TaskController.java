package org.tse.td1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.tse.td1.domain.Task;
import org.tse.td1.services.TaskService;
import org.tse.td1.utilities.Label;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    public Collection<Task> getTasks(){
        return taskService.findAllTasks();
    }

    @PostMapping("/tasks")
    public Task postTask(@Valid @RequestBody Task task) {
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}



