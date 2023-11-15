package com.balarawool.monitorvt;

import com.balarawool.monitorvt.data.DataStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class PortfolioController {
    record Revenue(String revenue) {}
    record Profit(String profit) {}
    record OperatingIncome(String operatingIncome) {}
    record NetIncome(String netIncome) {}
    record Assets(String assets) {}
    record Liabilities(String liabilities) {}
    record Equity(String equity) {}
    record Ticker(String ticker) {}

    private DataStore dataStore;
    private Lock lock;

    public PortfolioController(DataStore dataStore) {
        this.dataStore = dataStore;
        this.lock = new ReentrantLock();
    }

    @GetMapping("/revenue")
    Revenue revenue(@RequestParam Map<String, String> params) {
        return new Revenue(dataStore.getRevenue(params.get("name")));
    }

    @GetMapping("/profit")
    Profit profit(@RequestParam Map<String, String> params) {
        return new Profit(dataStore.getProfit(params.get("name")));
    }

    @GetMapping("/operatingIncome")
    OperatingIncome operatingIncome(@RequestParam Map<String, String> params) {
        return new OperatingIncome(dataStore.getOperatingIncome(params.get("name")));
    }

    @GetMapping("/netIncome")
    NetIncome netIncome(@RequestParam Map<String, String> params) {
        return new NetIncome(dataStore.getNetIncome(params.get("name")));
    }

    @GetMapping("/assets")
    Assets assets(@RequestParam Map<String, String> params) {
        return new Assets(dataStore.getAssets(params.get("name")));
    }

    @GetMapping("/liabilities")
    Liabilities liabilities(@RequestParam Map<String, String> params) {
        return new Liabilities(dataStore.getLiabilities(params.get("name")));
    }

//    @GetMapping("/equity")
//    Equity equity(@RequestParam Map<String, String> params) {
//        try {
//            if(lock.tryLock(10, TimeUnit.SECONDS)){
//                return new Equity(dataStore.getEquity(params.get("name")));
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally{
//            //release lock
//            lock.unlock();
//        }
//        throw new IllegalStateException("Cannot return data. No lock acquired on DataStore or error during acquiring lock.");
//    }

    @GetMapping("/equity")
    Equity equity(@RequestParam Map<String, String> params) {
        synchronized (dataStore) {
            var delay = Math.random() >= 0.7d;
            if (delay) {
                try {
                    Thread.sleep(5 * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return new Equity(dataStore.getEquity(params.get("name")));
        }
    }

    @GetMapping("/ticker")
    Ticker ticker(@RequestParam Map<String, String> params) {
        return new Ticker(dataStore.getTicker(params.get("name")));
    }
}
