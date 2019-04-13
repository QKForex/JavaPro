package com.qkforex.dev;


import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExectorTest {

    public static void main(String[] args) {
        ScheduledExecutorService service=Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(()->System.out.println("task ScheduledExecutorService " + new Date()), 0, 3, TimeUnit.SECONDS);

    }
}
