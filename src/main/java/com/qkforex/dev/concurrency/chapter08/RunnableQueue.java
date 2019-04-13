package com.qkforex.dev.concurrency.chapter08;

public interface RunnableQueue {

    void offer(Runnable runnable);

    Runnable take() throws InterruptedException;

    int size();

}
