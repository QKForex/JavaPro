package com.qkforex.dev.concurrency.chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadSleep {
    public static void main(String[] args) {
        new Thread(()->
        {
            long starttime=System.currentTimeMillis();
            sleep(20);

            long endtime=System.currentTimeMillis();
            System.out.println(String.format("Total spend %d ms",endtime-starttime));
        }).start();

        long starttime=System.currentTimeMillis();
        sleep(30);
        long endtime=System.currentTimeMillis();
        System.out.println(String.format("Total spend %d ms",endtime-starttime));
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
