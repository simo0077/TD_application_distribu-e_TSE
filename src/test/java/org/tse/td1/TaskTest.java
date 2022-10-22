package org.tse.td1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.tse.td1.domain.Developer;
import org.tse.td1.domain.Task;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
class TaskTest {

    @Test
    void testAddDeveloperToTask(){
        Task task = new Task();
        Developer developer = new Developer();
        task.addDeveloper(developer);
        Assert.assertEquals(1,task.getDeveloperSet().size());
    }
}
