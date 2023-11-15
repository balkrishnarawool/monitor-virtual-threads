package com.balarawool.monitorvt;

import com.balarawool.monitorvt.data.DataStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
public class VTController {

    @GetMapping("/thread-info")
    String threadInfo() {
        return Thread.currentThread().toString();
    }

    @GetMapping("/thread-info-delayed")
    String threadInfoDelayed() {
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Thread.currentThread().toString();
    }

}
