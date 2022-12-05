package org.tse.td1.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.tse.td1.domain.*;
import org.tse.td1.repositories.*;

import java.time.LocalDate;
import java.util.HashSet;

@Profile("test")
@Component
public class PopulateDbForTest implements CommandLineRunner {
    @Autowired
    TaskStatusRepo taskStatusRepo;
    @Autowired
    DeveloperRepo developerRepo;
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    TaskTypeRepo taskTypeRepo;
    @Autowired
    ChangeLogRepo changeLogRepo;


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
        Developer developer1 = new Developer(1L,"user1","user1","pass","user@user", LocalDate.now());
        Developer developer2 = new Developer(2L,"user2","user2","pass","user@user", LocalDate.now());
        Task task1 = new Task(1L,"task1",10,9, LocalDate.now(),taskStatus2,taskType1,new HashSet<>());
        task1.addDeveloper(developer1);
        task1.addDeveloper(developer2);
        taskStatusRepo.save(taskStatus1);
        taskTypeRepo.save(taskType1);
        developerRepo.save(developer1);
        developerRepo.save(developer2);
        taskRepo.save(task1);

    }
}
