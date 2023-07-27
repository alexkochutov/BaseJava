package com.basejava.webapp.util;

public class DeadLock {
    private static final Object LOCK_1 = new Object();
    private static final Object LOCK_2 = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            synchronized (LOCK_1) {
                System.out.println(Thread.currentThread().getName() + ": LOCK_1 is successfully locked");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (LOCK_2) {
                    System.out.println(Thread.currentThread().getName() + ": LOCK_2 is successfully locked");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (LOCK_2) {
                System.out.println(Thread.currentThread().getName() + ": LOCK_2 is successfully locked");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (LOCK_1) {
                    System.out.println(Thread.currentThread().getName() + ": LOCK_1 is successfully locked");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}