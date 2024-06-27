package com.smartcase.controller;

import com.smartcase.dto.StockDTO;
import com.smartcase.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stocks/financial-performance")
    public List<StockDTO> getStocksByFinancialPerformance(
            @RequestParam float fiveYearCagr,
            @RequestParam float fiveYearProfitGrowth,
            @RequestParam float fiveYearSalesGrowth) {
        return stockService.getStocksByFinancialPerformance(fiveYearCagr, fiveYearProfitGrowth, fiveYearSalesGrowth);
    }

    @GetMapping("/stocks/valuation-metrics")
    public List<StockDTO> getStocksByValuationMetrics(
            @RequestParam float peRatio,
            @RequestParam float pbRatio,
            @RequestParam float dividendYield) {
        return stockService.getStocksByValuationMetrics(peRatio, pbRatio, dividendYield);
    }

    @GetMapping("/stocks/market-cap")
    public List<StockDTO> getStocksByMarketCap(@RequestParam float marketCap) {
        return stockService.getStocksByMarketCap(marketCap);
    }

    @GetMapping("/stocks/recent-performance")
    public List<StockDTO> getStocksByRecentPerformance(@RequestParam int days) {
        return stockService.getStocksByRecentPerformance(days);
    }

    @GetMapping("/stocks/combined-criteria")
    public List<StockDTO> getStocksByCombinedCriteria(
            @RequestParam float peRatio,
            @RequestParam float pbRatio,
            @RequestParam float dividendYield,
            @RequestParam float fiveYearCagr,
            @RequestParam float fiveYearProfitGrowth,
            @RequestParam float fiveYearSalesGrowth) {
        return stockService.getStocksByCombinedCriteria(peRatio, pbRatio, dividendYield, fiveYearCagr, fiveYearProfitGrowth, fiveYearSalesGrowth);
    }

    @GetMapping("/stocks/sector")
    public List<StockDTO> getStocksBySector(@RequestParam String industryName) {
        return stockService.getStocksBySector(industryName);
    }

    @GetMapping("/stocks/dividend-yield")
    public List<StockDTO> getStocksByDividendYield(@RequestParam float dividendYield) {
        return stockService.getStocksByDividendYield(dividendYield);
    }
}
