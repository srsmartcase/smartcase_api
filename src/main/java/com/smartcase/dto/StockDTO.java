package com.smartcase.dto;

public class StockDTO {

    private String symbol;
    private String isin;
    private Float peRatio;
    private Float pbRatio;
    private Float dividendYieldInPercent;
    private Float fiveYearCagr;
    private Float fiveYearProfitGrowth;
    private Float fiveYearSalesGrowth;
    private Float marketCap;
    private String industryName;

    // Constructors
    public StockDTO() {
    }

    public StockDTO(String symbol, String isin, Float peRatio, Float pbRatio, Float dividendYieldInPercent, Float fiveYearCagr,
                    Float fiveYearProfitGrowth, Float fiveYearSalesGrowth, Float marketCap, String industryName) {
        this.symbol = symbol;
        this.isin = isin;
        this.peRatio = peRatio;
        this.pbRatio = pbRatio;
        this.dividendYieldInPercent = dividendYieldInPercent;
        this.fiveYearCagr = fiveYearCagr;
        this.fiveYearProfitGrowth = fiveYearProfitGrowth;
        this.fiveYearSalesGrowth = fiveYearSalesGrowth;
        this.marketCap = marketCap;
        this.industryName = industryName;
    }

    // Getters and Setters
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Float getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(Float peRatio) {
        this.peRatio = peRatio;
    }

    public Float getPbRatio() {
        return pbRatio;
    }

    public void setPbRatio(Float pbRatio) {
        this.pbRatio = pbRatio;
    }

    public Float getDividendYieldInPercent() {
        return dividendYieldInPercent;
    }

    public void setDividendYieldInPercent(Float dividendYieldInPercent) {
        this.dividendYieldInPercent = dividendYieldInPercent;
    }

    public Float getFiveYearCagr() {
        return fiveYearCagr;
    }

    public void setFiveYearCagr(Float fiveYearCagr) {
        this.fiveYearCagr = fiveYearCagr;
    }

    public Float getFiveYearProfitGrowth() {
        return fiveYearProfitGrowth;
    }

    public void setFiveYearProfitGrowth(Float fiveYearProfitGrowth) {
        this.fiveYearProfitGrowth = fiveYearProfitGrowth;
    }

    public Float getFiveYearSalesGrowth() {
        return fiveYearSalesGrowth;
    }

    public void setFiveYearSalesGrowth(Float fiveYearSalesGrowth) {
        this.fiveYearSalesGrowth = fiveYearSalesGrowth;
    }

    public Float getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Float marketCap) {
        this.marketCap = marketCap;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }
}
