package com.qkforex.dev.concurrency.chapter06;

public class ThreadGroupCreater {
    public static void main(String[] args) {
        //get threadgroup of current thread
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup group1 = new ThreadGroup("Group1");

        System.out.println(group1.getParent() == currentGroup);

        ThreadGroup group2 = new ThreadGroup(group1, "group2");

        System.out.println(group2.getParent() == group1);
    }
}
