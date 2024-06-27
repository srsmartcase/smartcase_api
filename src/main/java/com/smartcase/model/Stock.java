package com.smartcase.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_details")
public class Stock {
    @Id
    private String isin;
    private String symbol;
    private Float peRatio;
    private Float pbRatio;
    private Float dividendYieldInPercent;
    private Float marketCap;
    private String industryName;

    // Getters and setters
}
