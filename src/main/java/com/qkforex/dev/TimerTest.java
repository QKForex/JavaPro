package com.qkforex.dev;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        TimerTask tt=new TimerTask() {
            @Override
            public void run() {
                System.out.println("this is my timertask");
            }
        };
        Timer timer=new Timer();
        timer.schedule(tt,10,3000);

    }


}
