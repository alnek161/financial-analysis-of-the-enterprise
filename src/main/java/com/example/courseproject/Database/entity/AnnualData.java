package com.example.courseproject.Database.entity;

import javax.persistence.*;

@Entity
@Table(name = "AnnualData")
public class AnnualData {
    @Id
    @Column(name = "idAnnualData")
    private int idAnnualData;

    @Column(name = "year", nullable = false)
    private int year;

    @ManyToOne
    @JoinColumn(name = "idCompany", nullable = false)
    private Company company;

    // Constructors, getters, and setters
}
