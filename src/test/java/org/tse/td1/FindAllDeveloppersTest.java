package org.tse.td1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.tse.td1.domain.Developer;
import org.tse.td1.domain.Task;
import org.tse.td1.repositories.DeveloperRepo;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
public class FindAllDeveloppersTest {
    @Autowired
    DeveloperRepo developerRepo;
    @Test
    void testFindAllDevelopers(){
        Assert.assertEquals(2,developerRepo.findAll().size());
    }

}
