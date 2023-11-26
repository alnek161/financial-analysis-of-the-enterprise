package com.example.courseproject.Database.entity;

import javax.persistence.*;

@Entity
@Table(name = "Profitability")
public class Profitability {
    @Id
    @Column(name = "idProfitability")
    private int idProfitability;

    @Column(name = "profit")
    private Float profit;

    @Column(name = "capCurr")
    private Float capCurr;

    @Column(name = "capPrev")
    private Float capPrev;

    @Column(name = "netProfit")
    private Float netProfit;

    @Column(name = "interestPayments")
    private Float interestPayments;

    @Column(name = "taxRate")
    private Float taxRate;

    @Column(name = "assetsCur")
    private Float assetsCur;

    @Column(name = "assetsPrev")
    private Float assetsPrev;

    @Column(name = "equityCur")
    private Float equityCur;

    @Column(name = "equityPrev")
    private Float equityPrev;

    @Column(name = "obligationsCurr")
    private Float obligationsCurr;

    @Column(name = "obligationsPrev")
    private Float obligationsPrev;

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "AnnualData_idAnnualData", referencedColumnName = "idAnnualData", nullable = false),
            @JoinColumn(name = "AnnualData_year", referencedColumnName = "year", nullable = false)
    })
    private AnnualData annualData;

    // Constructors, getters, and setters
}
