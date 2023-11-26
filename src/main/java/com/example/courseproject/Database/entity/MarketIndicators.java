package com.example.courseproject.Database.entity;

import javax.persistence.*;

@Entity
@Table(name = "MarketIndicators")
public class MarketIndicators {
    @Id
    @Column(name = "idMarketIndicators")
    private int idMarketIndicators;

    @Column(name = "stockProfitability")
    private Float stockProfitability;

    @Column(name = "stockNumber")
    private Float stockNumber;

    @Column(name = "stockBeginPrice")
    private Float stockBeginPrice;

    @Column(name = "stockEndPrice")
    private Float stockEndPrice;

    @Column(name = "dividends")
    private Float dividends;

    @ManyToOne
    @JoinColumn(name = "AnnualData_idAnnualData", nullable = false)
    private AnnualData annualData;

    // Constructors, getters, and setters
}
