package org.tse.td1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tse.td1.domain.Developer;
import org.tse.td1.services.DeveloperService;

import java.util.List;

@RestController
public class DeveloperController {
    @Autowired
    DeveloperService developerService;

    @GetMapping("/developpers")
    public List<Developer> getDeveloppers(){
        return developerService.findAllDevelopers();
    }
}
