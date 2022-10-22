package org.tse.td1.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private Integer nbrhoursforcas;
    private Integer nbrhourreel;
    private Date created;
    @ManyToOne
    private TaskStatus taskStatus;
    @ManyToOne
    private TaskType taskType;
    @ManyToMany(fetch=FetchType.EAGER)
    private Set<Developer> developerSet;

    public Task() {

        this.developerSet = new HashSet<>();
    }
    public void addDeveloper(Developer developer){
        this.developerSet.add(developer);
    }



}
