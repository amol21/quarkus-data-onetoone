package org.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    Citizen citizen;


    public Aadhar(Long id, Long aadharNumber, String company, Citizen citizen) {
        this.id = id;
        this.aadharNumber = aadharNumber;
        this.company = company;
        this.citizen = citizen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(Long aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    @Override
    public String toString() {
        return "Aadhar{" +
                "id=" + id +
                ", aadharNumber=" + aadharNumber +
                ", company='" + company + '\'' +
                ", citizen=" + citizen +
                '}';
    }
}
