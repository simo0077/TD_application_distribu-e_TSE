package org.tse.td1.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Developer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    String firstname;
    String lastname;
    String password;
    String email;
    LocalDate Startcontract;



}
