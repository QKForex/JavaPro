package com.qkforex.dev.concurrency.chapter05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

public class BooleanLock implements Lock {

    private Thread currentthread;

    private boolean locked = false;

    private final List<Thread> blockedList = new ArrayList<>();

    @Override
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (locked) {
                if(!blockedList.contains(currentThread())){
                    blockedList.add(currentThread());
                    this.wait();
                }

            }
            blockedList.remove(currentThread());
            this.locked = true;
            this.currentthread = currentThread();

        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this) {
            if (mills <= 0) {
                this.lock();
            } else {
                long remainingMills = mills;
                long endMills = currentTimeMills() + remainingMills;
                while (locked) {
                    if (remainingMills <= 0)
                        throw new TimeoutException(("can not get the lock running " + mills));
                    if (!blockedList.contains(currentThread()))
                        blockedList.add(currentThread());
                    this.wait(remainingMills);
                    remainingMills = endMills - currentTimeMills();
                }
                blockedList.remove(currentThread());
                this.locked=true;
                this.currentthread=currentThread();
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (this)
        {
            if(currentthread==currentThread())
            {
                this.locked=false;
                Optional.of(currentThread().getName()+" release the lock.").ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    private long currentTimeMills() {
        return System.currentTimeMillis();
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }

    public Thread currentThread()
    {
        return Thread.currentThread();
    }
}
