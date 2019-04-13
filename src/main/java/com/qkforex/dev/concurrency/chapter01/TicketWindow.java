package com.qkforex.dev.concurrency.chapter01;

public class TicketWindow extends Thread {
    private String name;
    private static int MAX=50;
    private static int index=1;
    TicketWindow(String name)
    {
        this.name=name;
    }


    @Override
    public void run() {
         while(index<MAX)
         {
             System.out.println("Window "+name +"Currecnt Number is "+ index++);
         }
    }

    public static void main(String[] args) {
        TicketWindow t1=new TicketWindow("Windows 1 ");
        TicketWindow t2=new TicketWindow("Windows 2 ");
        TicketWindow t3=new TicketWindow("Windows 3 ");
        TicketWindow t4=new TicketWindow("Windows 4 ");


        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
