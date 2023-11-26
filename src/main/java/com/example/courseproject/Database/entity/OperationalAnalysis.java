package com.example.courseproject.Database.entity;

import javax.persistence.*;

@Entity
@Table(name = "OperationalAnalysis")
public class OperationalAnalysis {
    @Id
    @Column(name = "idOperationalAnalysis")
    private int idOperationalAnalysis;

    @Column(name = "revenueCurr")
    private Float revenueCurr;

    @Column(name = "revenuePrev")
    private Float revenuePrev;

    @Column(name = "income")
    private Float income;

    @Column(name = "netProfit")
    private Float netProfit;

    @ManyToOne
    @JoinColumn(name = "AnnualData_idAnnualData", nullable = false)
    private AnnualData annualData;

    // Constructors, getters, and setters
}
