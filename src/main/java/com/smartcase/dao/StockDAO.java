package com.smartcase.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StockDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> getStocksByFinancialPerformance(float fiveYearCagr, float fiveYearProfitGrowth, float fiveYearSalesGrowth) {
        String sql = "SELECT symbol, isin, pe_ratio, pb_ratio, dividend_yield_in_percent, five_year_cagr, five_year_profit_growth, five_year_sales_growth " +
                "FROM public.stock_details WHERE five_year_cagr > ? AND five_year_profit_growth > ? AND five_year_sales_growth > ?";
        return jdbcTemplate.queryForList(sql, fiveYearCagr, fiveYearProfitGrowth, fiveYearSalesGrowth);
    }

    public List<Map<String, Object>> getStocksByValuationMetrics(float peRatio, float pbRatio, float dividendYield) {
        String sql = "SELECT symbol, isin, pe_ratio, pb_ratio, dividend_yield_in_percent " +
                "FROM public.stock_details WHERE pe_ratio < ? AND pb_ratio < ? AND dividend_yield_in_percent > ?";
        return jdbcTemplate.queryForList(sql, peRatio, pbRatio, dividendYield);
    }

    public List<Map<String, Object>> getStocksByMarketCap(float marketCap) {
        String sql = "SELECT symbol, isin, market_cap FROM public.stock_details WHERE market_cap > ?";
        return jdbcTemplate.queryForList(sql, marketCap);
    }

    public List<Map<String, Object>> getStocksByRecentPerformance(int days) {
        String sql = "SELECT symbol, isin, close_price, date, volume " +
                "FROM public.screener_stock_history WHERE date > current_date - interval '? days' AND close_price > fifty_dma";
        return jdbcTemplate.queryForList(sql, days);
    }

    public List<Map<String, Object>> getStocksByCombinedCriteria(float peRatio, float pbRatio, float dividendYield, float fiveYearCagr, float fiveYearProfitGrowth, float fiveYearSalesGrowth) {
        String sql = "SELECT sd.symbol, sd.isin, sd.pe_ratio, sd.pb_ratio, sd.dividend_yield_in_percent, sf.five_year_cagr, sf.five_year_profit_growth, sf.five_year_sales_growth " +
                "FROM public.stock_details sd JOIN public.stock_financial sf ON sd.isin = sf.isin WHERE sd.pe_ratio < ? AND sd.pb_ratio < ? AND sd.dividend_yield_in_percent > ? " +
                "AND sf.five_year_cagr > ? AND sf.five_year_profit_growth > ? AND sf.five_year_sales_growth > ?";
        return jdbcTemplate.queryForList(sql, peRatio, pbRatio, dividendYield, fiveYearCagr, fiveYearProfitGrowth, fiveYearSalesGrowth);
    }

    public List<Map<String, Object>> getStocksBySector(String industryName) {
        String sql = "SELECT symbol, isin, industry_name, market_cap FROM public.stock_details WHERE industry_name = ?";
        return jdbcTemplate.queryForList(sql, industryName);
    }

    public List<Map<String, Object>> getStocksByDividendYield(float dividendYield) {
        String sql = "SELECT symbol, isin, dividend_yield_in_percent FROM public.stock_details WHERE dividend_yield_in_percent > ?";
        return jdbcTemplate.queryForList(sql, dividendYield);
    }
}
