package com.basejava.webapp.util;

public class DeadLock {
    private static final String LOCK_1 = "LOCK_1";
    private static final String LOCK_2 = "LOCK_2";

    public static void main(String[] args) {

        deadlock(LOCK_1, LOCK_2);
        deadlock(LOCK_2, LOCK_1);

    }

    private static void deadlock(String lock1, String lock2) {
        new Thread(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + ": " + lock1 + " is successfully locked");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + ": " + lock2 + " is successfully locked");
                }
            }
        }).start();
    }
}