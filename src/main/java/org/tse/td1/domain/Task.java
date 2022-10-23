package org.tse.td1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private Integer nbrhoursforcas;
    private Integer nbrhourreel;
    private LocalDate created;
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
