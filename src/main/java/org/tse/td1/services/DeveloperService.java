package org.tse.td1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tse.td1.domain.Developer;
import org.tse.td1.repositories.DeveloperRepo;
import org.tse.td1.servicesI.DeveloperServiceI;

import java.util.List;

@Component
public class DeveloperService implements DeveloperServiceI {
    @Autowired
    DeveloperRepo developerRepo;

    @Override
    public List<Developer> findAllDevelopers() {
        return developerRepo.findAll();
    }
}
