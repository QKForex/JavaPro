package com.qkforex.dev.concurrency.chapter07;

import java.util.concurrent.TimeUnit;

public class CaptureThreadException {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t, e) ->
        {
            System.out.println(t.getName() + " orrur exception");

            e.printStackTrace();
            System.exit(1);
        });

        final Thread thread = new Thread(() ->
        {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);

                } catch (InterruptedException e) {
                    // e.printStackTrace();
                }
                System.out.println(1 / 0);
            }
        }, "Test-thread");
        thread.start();

        final Thread thread2 = new Thread(() ->
        {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);

                } catch (InterruptedException e) {
                    // e.printStackTrace();
                }
            }
        }, "Test-thread2");

        thread2.start();
    }
}
