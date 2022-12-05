package org.tse.td1.ControllersTests;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.tse.td1.domain.Developer;
import org.tse.td1.domain.Task;
import org.tse.td1.domain.TaskStatus;
import org.tse.td1.repositories.DeveloperRepo;
import org.tse.td1.repositories.TaskStatusRepo;
import org.tse.td1.utilities.Label;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
public class TaskControllerTest {
    @Autowired
    TaskStatusRepo taskStatusRepo;
    @Autowired
    DeveloperRepo developerRepo;
    @Autowired
    private MockMvc mvc;
    @Test
    public void testGetTasks() throws Exception {
        mvc.perform(get("/tasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title", is("task1")))
                .andExpect(jsonPath("$[0].nbrhoursforcas", is(10)))
                .andExpect(jsonPath("$[0].developerSet[0].firstname", is("user2")));
        ;
    }

    @Test
    public void testPostTask() throws Exception {
        Developer developer = new Developer();
        developer.setFirstname("user1");
        developer.setLastname("user1");
        developerRepo.save(developer);
        Task task = new Task();
        task.setTitle("task1");
        task.addDeveloper(developer);
        mvc.perform(post("/tasks")
                        .content(asJsonString(task))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
        ;
    }

    @Test
    public void testPatchTaskLeft() throws Exception {
        Label label = new Label();
        label.setLabel("left");
        mvc.perform(patch("/tasks/1")
                        .content(asJsonString(label))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("title", is("task1")))
                .andExpect(jsonPath("taskStatus.label", is("status 1")));
        ;
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
