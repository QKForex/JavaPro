package com.qkforex.dev.concurrency.chapter01;

import java.util.concurrent.TimeUnit;

public class TryConcurrency {

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                enjoyMusic();
            }
        }.start();
        //enjoyMusic();
        borwseNews();
    }
    public static void enjoyMusic()
    {
       for(;;)
       {
           System.out.println("uhh ,nice music");
           sleep(1);
       }
    }

    public static void borwseNews()
    {
        for(;;)
        {
            System.out.println("uhh ,good news");
            sleep(1);
        }
    }

    public static void sleep(int second)
    {

        try {
            TimeUnit.SECONDS.sleep(second);
        }catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}
