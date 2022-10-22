package org.tse.td1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.td1.domain.Task;

public interface TaskRepo extends JpaRepository<Task,Long> {
}
