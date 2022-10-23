package org.tse.td1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.td1.domain.TaskStatus;

public interface TaskStatusRepo extends JpaRepository<TaskStatus,Long> {
    TaskStatus findByLabel(String label);
}
