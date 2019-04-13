package com.qkforex.dev.concurrency.chapter07;

import java.util.concurrent.TimeUnit;

public class ThreadHook {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
                                                 @Override
                                                 public void run() {
                                                     try {
                                                         System.out.println("the hook thread 1 is running");
                                                         TimeUnit.MILLISECONDS.sleep(1);
                                                     } catch (InterruptedException e) {
                                                         e.printStackTrace();
                                                     }
                                                     System.out.println("the hook thread 1 will exit.");
                                                 }
                                             }

        );

        Runtime.getRuntime().addShutdownHook(new Thread() {
                                                 @Override
                                                 public void run() {
                                                     try {
                                                         System.out.println("the hook thread 2 is running");
                                                         TimeUnit.MILLISECONDS.sleep(2);
                                                     } catch (InterruptedException e) {
                                                         e.printStackTrace();
                                                     }
                                                     System.out.println("the hook thread 2 will exit.");
                                                 }
                                             }

        );


    }
}
