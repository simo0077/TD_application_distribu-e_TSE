package org.tse.td1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tse.td1.domain.ChangeLog;

import java.util.List;

public interface ChangeLogRepo extends JpaRepository<ChangeLog,Long> {
    List<ChangeLog> findByTaskId(Long TaskId);
}
