package com.qkforex.dev.concurrency.chapter03;

import io.swagger.models.auth.In;

import java.util.concurrent.TimeUnit;

public class InterruptThreadExit2 {
    public static void main(String[] args)  throws InterruptedException {
        Thread t=new Thread()
        {
            @Override
            public void run() {
                System.out.println("I will start work");
                for(;;) {
                    try {
                        TimeUnit.SECONDS.sleep(1);

                    } catch (InterruptedException e) {
                        break;
                    }
                }
                System.out.println("I will be exiting.");
            }
        };
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("System will be shutdown.");
        t.interrupt();

    }
}
