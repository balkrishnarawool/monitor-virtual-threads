package com.balarawool.monitorvt.data;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DataStore {
    public static final Map<String, String> REVENUE = Map.of("Microsoft", "56.52  B", "Apple", "89.5  B", "Amazon", "143.08 B", "Google", "76.69 B", "Facebook", "34.15 B", "Netflix", "8.54 B");
    public static final Map<String, String> PROFIT = Map.of("Microsoft", "40.22 B", "Apple", "40.43 B", "Amazon", "68.06 B", "Google", "43.46 B", "Facebook", "27.95 B", "Netflix", "3.61 B");
    public static final Map<String, String> OPERATING_INCOME = Map.of("Microsoft", "26.9 B", "Apple", "26.97 B", "Amazon", "11.43 B", "Google", "21.34 B", "Facebook", "14.13 B", "Netflix", "1.92 B");
    public static final Map<String, String> NET_INCOME = Map.of("Microsoft", "22.29 B", "Apple", "22.96 B", "Amazon", "9.88 B", "Google", "19.69 B", "Facebook", "11.58 B", "Netflix", "1.68 B");
    public static final Map<String, String> ASSETS = Map.of("Microsoft", "445.79 B", "Apple", "352.58 B", "Amazon", "486.88 B", "Google", "396.71 B", "Facebook", "216.27 B", "Netflix", "49.5 B");
    public static final Map<String, String> LIABILITIES = Map.of("Microsoft", "225.07 B", "Apple", "290.44 B", "Amazon", "303.91 B", "Google", "123.51 B", "Facebook", "73.4 B", "Netflix", "27.39 B");
    public static final Map<String, String> EQUITY = Map.of("Microsoft", "220.71 B", "Apple", "62.15 B", "Amazon", "182.97 B", "Google", "273.2 B", "Facebook", "142.87 B", "Netflix", "22.11 B");
    public static final Map<String, String> TICKER = Map.of("Microsoft", "MSFT", "Apple", "AAPL", "Amazon", "AMZN", "Google", "GOOG", "Facebook", "META", "Netflix", "NFLX");

    public String getRevenue(String name) {
        return REVENUE.get(name);
    }

    public String getProfit(String name) {
        return PROFIT.get(name);
    }

    public String getOperatingIncome(String name) {
        return OPERATING_INCOME.get(name);
    }

    public String getNetIncome(String name) {
        return NET_INCOME.get(name);
    }

    public String getAssets(String name) {
        return ASSETS.get(name);
    }

    public String getLiabilities(String name) {
        return LIABILITIES.get(name);
    }

    public String getEquity(String name) {
        return EQUITY.get(name);
    }

    public String getTicker(String name) {
        return TICKER.get(name);
    }
}
