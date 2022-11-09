package org.tse.td1.servicesI;


import org.tse.td1.domain.Task;

import java.util.Collection;

public interface TaskServiceI {
    public Collection<Task> findAllTasks();

    public Task addTask(Task task);

    public Task findTask(Long id);

    public Task moveRightTask(Task task);

    public Task moveLeftTask(Task task);
}
