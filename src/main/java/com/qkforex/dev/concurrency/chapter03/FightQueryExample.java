package com.qkforex.dev.concurrency.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FightQueryExample {
    private static List<String> fightcompany = Arrays.asList("CSA", "CEA", "HNA");

    public static void main(String[] args) {
        List<String> results=search("SH","BJ");
        System.out.println("=====================results=======================");
        results.forEach(System.out::println);
    }

    private static List<String> search(String origin, String destination) {
             final List<String> result=new ArrayList<>();
             List<FightQueryTask> tasks=fightcompany.stream().map(f->createSearchTask(f,origin,destination)).collect(toList());

             tasks.forEach(Thread::start);
             tasks.forEach(t->
             {
                 try{
                     t.join();

                 }catch(InterruptedException e)
                 {
                     e.printStackTrace();
                 }
             });
             tasks.stream().map(FightQuery::get).forEach(result::addAll);
             return result;
    }

    private static FightQueryTask createSearchTask(String fight, String origin, String destination) {


        return new FightQueryTask(fight,origin,destination);
    }


}
