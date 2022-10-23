package org.tse.td1;

import org.apache.catalina.Service;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.tse.td1.domain.Task;
import org.tse.td1.repositories.TaskStatusRepo;
import org.tse.td1.services.TaskService;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
class TaskServiceMethodsTest {
    @Autowired
    TaskService taskService;

    @Test
    void testFindAllTasks() {
        Assert.assertEquals(1, taskService.findAllTasks().size());
    }

    @Test
    void testFindTaskById() {
        Assert.assertEquals("task1", taskService.findTask(1L).getTitle());
    }

    @Autowired
    TaskStatusRepo taskStatusRepo;

    @Test
    void testMoveRightTask() {
        Task task = new Task();
        task.setTaskStatus(taskStatusRepo.findByLabel("status 2"));
        task = taskService.moveRightTask(task);
        Assert.assertEquals("status 3", task.getTaskStatus().getLabel());

        task.setTaskStatus(taskStatusRepo.findByLabel("status 4"));
        task = taskService.moveRightTask(task);
        Assert.assertEquals("status 4", task.getTaskStatus().getLabel());

    }

    @Test
    void testMoveLeftTask() {
        Task task = new Task();
        task.setTaskStatus(taskStatusRepo.findByLabel("status 3"));
        task = taskService.moveLeftTask(task);
        Assert.assertEquals("status 2", task.getTaskStatus().getLabel());


    }

}
