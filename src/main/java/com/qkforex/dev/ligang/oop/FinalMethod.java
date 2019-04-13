package com.qkforex.dev.ligang.oop;

public class FinalMethod {

    //final
    int getage(){
        return 10;
    }

    class ChildFinalMethod extends FinalMethod{
        int getage()
        {
return 1;
        }
    }
}
