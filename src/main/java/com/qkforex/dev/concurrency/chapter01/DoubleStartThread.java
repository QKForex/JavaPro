package com.qkforex.dev.concurrency.chapter01;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@Slf4j
public class DoubleStartThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);

                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        };
        t.start();
        log.info("thread started");
        TimeUnit.SECONDS.sleep(2);//已经结束生命周期,再次启动无法激活
        t.start();//not allowed
    }
}
