package com.qkforex.dev.ligang.oop;

public class FinalVar {
    final public int a =6 ;//initial value when defined variable
    final String str; // only initial in initial block or constructor
    final static double d; // only initial in static block

    public FinalVar()
    {
      //this.str="";
    }
    {
        str="";
    }
    static
    {
        d=10;
    }

    public static void main(String[] args) {
        FinalVar fv=new FinalVar();
        System.out.println(fv.a);
        System.out.println(FinalVar.d);
        System.out.println(fv.str);

    }
}
