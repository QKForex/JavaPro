package com.qkforex.dev.concurrency.chapter03;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ThreadIsInterrupted {
    public static void main(String[] args)throws  InterruptedException {
        /*Thread t=new Thread(){
            @Override
            public void run() {
                while(true)
                {
                    //System.out.println();
                }
            }
        };
        t.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("thread is interrupted ?:"+t.isInterrupted());
        t.interrupt();
        System.out.println("thread is interrupted ?:"+t.isInterrupted());*/


        Thread t=new Thread(){
            @Override
            public void run() {
                while(true)
                {
                  try{
                      TimeUnit.MINUTES.sleep(1);
                  } catch (InterruptedException e)
                  {
                      //e.printStackTrace();
                      //ignore the exception
                      // here the intreeupt flag will be clear.

                      System.out.printf("I am be interripted ? %s \n",isInterrupted());

                  }
                }
            }
        };
        t.setDaemon(true);
        t.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.printf("thread is interripted ? %s \n",t.isInterrupted());
        t.interrupt();
        TimeUnit.SECONDS.sleep(2);
        System.out.printf("thread is interrupted ? % s \n",t.isInterrupted());

    }
}
