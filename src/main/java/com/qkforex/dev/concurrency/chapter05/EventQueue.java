package com.qkforex.dev.concurrency.chapter05;

import java.util.LinkedList;

public class EventQueue {
    private final int MAX;

    static class Event {
    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();
    private final static int DEFALT_MAX_EVENT = 10;

    public EventQueue() {
        this(DEFALT_MAX_EVENT);
    }

    public EventQueue(int max) {
        this.MAX = max;
    }

    public void offer(Event event) {
        synchronized (eventQueue) {
            if (eventQueue.size() >= MAX) {
                try {
                    console("the queue is full.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console("the new event is submitted");
            eventQueue.addLast(event);
            eventQueue.notify();
        }
    }

    public Event take() {
        synchronized (eventQueue) {
            if (eventQueue.isEmpty()) {
                try {
                    console("the queue is empty.");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            this.eventQueue.notify();
            console("the event " + event + " is handleed.");
            return event;
        }
    }

    private void console(String message) {
        System.out.printf("%s:%s\n", Thread.currentThread().getName(), message);
    }

}
