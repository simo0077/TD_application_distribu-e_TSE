package org.tse.td1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.td1.domain.TaskType;

public interface TaskTypeRepo extends JpaRepository<TaskType,Long> {
}
