package com.example.courseproject.Database.entity;

import javax.persistence.*;

@Entity
@Table(name = "LiquidityRatio")
public class LiquidityRatio {
    @Id
    @Column(name = "idLiquidityRatio")
    private int idLiquidityRatio;

    @Column(name = "assetsCurr")
    private Float assetsCurr;

    @Column(name = "responsibilityCurr")
    private Float responsibilityCurr;

    @Column(name = "cash")
    private Float cash;

    @Column(name = "marketableSecurities")
    private Float marketableSecurities;

    @Column(name = "accountsReceivable")
    private Float accountsReceivable;

    @ManyToOne
    @JoinColumn(name = "AnnualData_idAnnualData", nullable = false)
    private AnnualData annualData;

    // Constructors, getters, and setters
}
