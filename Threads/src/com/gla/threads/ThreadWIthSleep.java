package com.gla.threads;

public class ThreadWIthSleep extends Thread {

    public void run() {
        try {
            System.out.println("Task 1: Number");
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ThreadWIthSleep t1 = new ThreadWIthSleep();
        t1.start();
    }
}