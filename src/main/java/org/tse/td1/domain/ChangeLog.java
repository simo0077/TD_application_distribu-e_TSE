package org.tse.td1.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class ChangeLog {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    LocalDate occured;
    @ManyToOne
    Task task;
    @ManyToOne
    TaskStatus sourceStatus;
    @ManyToOne
    TaskStatus targetStatus;
    


}
