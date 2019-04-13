package com.qkforex.dev.concurrency.chapter03;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class FightQueryTask extends  Thread implements FightQuery {

    private final String origin;
    private final String destination;
    private final List<String> fightlist=new ArrayList<String>();
    public FightQueryTask(String airline,String origin,String destination)
    {
        super("["+airline+"]");//thread name
                this.origin=origin;
                this.destination=destination;
    }

    @Override
    public void run() {
        System.out.printf("%s-query from %s to %s \n",getName(),origin,destination);
        int randomVal=ThreadLocalRandom.current().nextInt(10);
        try
        {
            TimeUnit.SECONDS.sleep(randomVal);
            this.fightlist.add(getName()+"-"+randomVal);
            System.out.printf("The Flight %s query sucessfully \n",getName());
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> get() {
        return this.fightlist;
    }
}

