package com.qkforex.dev.concurrency.chapter08;

public interface ThreadPool {

    void execute(Runnable runnable);

    void shutdown();

    int getInitialSize();

    int getMaxSize();

    int getCoreSize();

    int getQueueSize();

    int getActiveCount();

    boolean isShutdown();
}
