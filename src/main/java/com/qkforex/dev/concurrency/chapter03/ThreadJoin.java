package com.qkforex.dev.concurrency.chapter03;

import io.swagger.models.auth.In;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadJoin {
    public static void main(String[] args) throws  InterruptedException{


        List<Thread> threads=IntStream.range(1,3).mapToObj(ThreadJoin::create).collect(Collectors.toList());
        threads.forEach(Thread::start);

        for (Thread thread:threads) {
            thread.join();
        }
        for (int i = 0; i <5 ; i++) {
            System.out.println(Thread.currentThread().getName()+"#"+i);
            shortSleep();
        }
    }

    public static Thread create(int index)
    {
        return new Thread(()->
        {
            for (int i = 0; i <100 ; i++) {
                System.out.println(Thread.currentThread().getName()+"#"+i);
                shortSleep();
            }
        },String.valueOf(index));

    }
    public static void shortSleep()
    {
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
