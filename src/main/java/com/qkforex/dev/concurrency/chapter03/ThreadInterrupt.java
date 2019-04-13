package com.qkforex.dev.concurrency.chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(() ->
        {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("oh,I am be interrupted");
            }
        });
        thread.start();
        sleep(2);
        thread.interrupt();

    }

    public static void sleep(long l)
    {
        try
        {
            //Thread.sleep(l);
            TimeUnit.SECONDS.sleep(l);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
