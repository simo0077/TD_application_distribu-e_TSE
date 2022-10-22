package org.tse.td1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tse.td1.domain.Developer;


@Repository
public interface DeveloperRepo extends JpaRepository<Developer,Long> {

}
