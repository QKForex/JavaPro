package com.qkforex.dev.concurrency.chapter01;

import java.util.concurrent.TimeUnit;

public class TickerWindowRunnable implements Runnable {

    private int index = 1;
    private final int MAX = 50;
    //private String name;
    private final Object MUTEX = new Object();

    TickerWindowRunnable() {

    }

    @Override
    public void run() {
        //System.out.println(Thread.currentThread().getName() + " starting ");
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (MUTEX) {
                if (index <= MAX) {
                    System.out.println(Thread.currentThread().getName() + " Currecnt Number is " + index++);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TickerWindowRunnable t1 = new TickerWindowRunnable();

        Thread tt1 = new Thread(t1, "Windows 1");
        Thread tt2 = new Thread(t1, "Windows 2");
        Thread tt3 = new Thread(t1, "Windows 3");
        Thread tt4 = new Thread(t1, "Windows 4");
        tt1.start();
        tt2.start();
        tt3.start();
        tt4.start();
        tt1.join();
        tt2.join();
        tt3.join();
        tt4.join();
        System.out.println("all ticket are sale out");
    }
}
