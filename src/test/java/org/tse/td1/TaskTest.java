package org.tse.td1;

import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.tse.td1.domain.Developer;
import org.tse.td1.domain.Task;
import org.tse.td1.repositories.DeveloperRepo;
import org.tse.td1.repositories.TaskRepo;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
class TaskTest {

    @Autowired
    TaskRepo taskRepo;

    @Test
    void findAllAndSaveTaskTest(){
        Assert.assertEquals(1,taskRepo.findAll().size());
        Task task2 = new Task();
        taskRepo.save(task2);
        Assert.assertEquals(2,taskRepo.findAll().size());
    }

}
