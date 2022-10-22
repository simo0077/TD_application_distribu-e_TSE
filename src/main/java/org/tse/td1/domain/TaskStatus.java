package org.tse.td1.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class TaskStatus {
    @Id //jpa, primary key//
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String label;

}
