package org.tse.td1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskStatus {
    @Id //jpa, primary key//
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String label;

}
