package org.data.entity;

import jakarta.persistence.*;

@Entity
public class Aadhar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long aadharNumber;
    String company;

    public Aadhar() {
    }
    @OneToOne
    Citizen citizen;
}
