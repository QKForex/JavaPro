package com.qkforex.dev.concurrency.chapter02;

import java.util.stream.IntStream;

public class NamedThread {
    private static final String PREFIX = "ALEX-";

    public static void main(String[] args) {
        IntStream.range(0, 5).mapToObj(NamedThread::createThread).forEach(Thread::start);
    }

    public static Thread createThread(final int num) {
        return new Thread(
                () -> System.out.println(Thread.currentThread().getName()),
                PREFIX + num
        );
    }
}
