package com.qkforex.dev.ligang.oop;

public class Singleton {

    private static Singleton instalce = null;

    public static Singleton getInstalce() {

        if (instalce == null) {
            instalce = new Singleton();
        }

        return instalce;
    }

    private Singleton() {
    }

    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstalce();
        Singleton s2 = Singleton.getInstalce();
        System.out.println(s1 == s2);
    }
}
