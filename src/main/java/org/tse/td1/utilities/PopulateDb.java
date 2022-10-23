package org.tse.td1.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tse.td1.domain.Developer;
import org.tse.td1.domain.Task;
import org.tse.td1.domain.TaskStatus;
import org.tse.td1.domain.TaskType;
import org.tse.td1.repositories.*;

import java.time.LocalDate;
import java.util.HashSet;


@Component
public class PopulateDb implements CommandLineRunner {
    @Autowired
    TaskStatusRepo taskStatusRepo;
    @Autowired
    TaskTypeRepo taskTypeRepo;


    @Override
    public void run(String... args) throws Exception {
        TaskStatus taskStatus1 = new TaskStatus(1L, "status 1");
        TaskStatus taskStatus2 = new TaskStatus(2L, "status 2");
        TaskStatus taskStatus3 = new TaskStatus(3L, "status 3");
        TaskStatus taskStatus4 = new TaskStatus(4L, "status 4");
        taskStatusRepo.save(taskStatus1);
        taskStatusRepo.save(taskStatus2);
        taskStatusRepo.save(taskStatus3);
        taskStatusRepo.save(taskStatus4);

        TaskType taskType1 = new TaskType(1L, "type1");
        TaskType taskType2 = new TaskType(2L, "type2");
        TaskType taskType3 = new TaskType(3L, "type3");
        TaskType taskType4 = new TaskType(4L, "type4");
        taskTypeRepo.save(taskType1);
        taskTypeRepo.save(taskType2);
        taskTypeRepo.save(taskType3);
        taskTypeRepo.save(taskType4);


    }
}
