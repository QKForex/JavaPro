package com.qkforex.dev.concurrency.chapter08;

public interface ThreadFactory {

    Thread createThread(Runnable runnable);
}
