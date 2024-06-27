package com.smartcase.service;

import com.smartcase.dao.StockDAO;
import com.smartcase.dto.StockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StockService {

    @Autowired
    private StockDAO stockDAO;

    private StockDTO mapToStockDTO(Map<String, Object> row) {
        StockDTO dto = new StockDTO();
        dto.setSymbol((String) row.get("symbol"));
        dto.setIsin((String) row.get("isin"));
        dto.setPeRatio(row.get("pe_ratio") != null ? ((Number) row.get("pe_ratio")).floatValue() : null);
        dto.setPbRatio(row.get("pb_ratio") != null ? ((Number) row.get("pb_ratio")).floatValue() : null);
        dto.setDividendYieldInPercent(row.get("dividend_yield_in_percent") != null ? ((Number) row.get("dividend_yield_in_percent")).floatValue() : null);
        dto.setFiveYearCagr(row.get("five_year_cagr") != null ? ((Number) row.get("five_year_cagr")).floatValue() : null);
        dto.setFiveYearProfitGrowth(row.get("five_year_profit_growth") != null ? ((Number) row.get("five_year_profit_growth")).floatValue() : null);
        dto.setFiveYearSalesGrowth(row.get("five_year_sales_growth") != null ? ((Number) row.get("five_year_sales_growth")).floatValue() : null);
        dto.setMarketCap(row.get("market_cap") != null ? ((Number) row.get("market_cap")).floatValue() : null);
        dto.setIndustryName((String) row.get("industry_name"));
        return dto;
    }

    public List<StockDTO> getStocksByFinancialPerformance(float fiveYearCagr, float fiveYearProfitGrowth, float fiveYearSalesGrowth) {
        List<Map<String, Object>> stocksData = stockDAO.getStocksByFinancialPerformance(fiveYearCagr, fiveYearProfitGrowth, fiveYearSalesGrowth);
        return mapToStockDTOList(stocksData);
    }

    public List<StockDTO> getStocksByValuationMetrics(float peRatio, float pbRatio, float dividendYield) {
        List<Map<String, Object>> stocksData = stockDAO.getStocksByValuationMetrics(peRatio, pbRatio, dividendYield);
        return mapToStockDTOList(stocksData);
    }

    public List<StockDTO> getStocksByMarketCap(float marketCap) {
        List<Map<String, Object>> stocksData = stockDAO.getStocksByMarketCap(marketCap);
        return mapToStockDTOList(stocksData);
    }

    public List<StockDTO> getStocksByRecentPerformance(int days) {
        List<Map<String, Object>> stocksData = stockDAO.getStocksByRecentPerformance(days);
        return mapToStockDTOList(stocksData);
    }

    public List<StockDTO> getStocksByCombinedCriteria(float peRatio, float pbRatio, float dividendYield, float fiveYearCagr, float fiveYearProfitGrowth, float fiveYearSalesGrowth) {
        List<Map<String, Object>> stocksData = stockDAO.getStocksByCombinedCriteria(peRatio, pbRatio, dividendYield, fiveYearCagr, fiveYearProfitGrowth, fiveYearSalesGrowth);
        return mapToStockDTOList(stocksData);
    }

    public List<StockDTO> getStocksBySector(String industryName) {
        List<Map<String, Object>> stocksData = stockDAO.getStocksBySector(industryName);
        return mapToStockDTOList(stocksData);
    }

    public List<StockDTO> getStocksByDividendYield(float dividendYield) {
        List<Map<String, Object>> stocksData = stockDAO.getStocksByDividendYield(dividendYield);
        return mapToStockDTOList(stocksData);
    }

    private List<StockDTO> mapToStockDTOList(List<Map<String, Object>> stocksData) {
        return stocksData.stream()
                .map(this::mapToStockDTO)
                .collect(Collectors.toList());
    }
}
