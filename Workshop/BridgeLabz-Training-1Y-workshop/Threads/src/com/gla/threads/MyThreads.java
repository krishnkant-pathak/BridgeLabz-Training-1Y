package com.gla.threads;

public class MyThreads implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Error Occurred");
            }
        }
    }

    public static void main(String[] args) {
        MyThreads t1 = new MyThreads();
        Thread tt1 = new Thread(t1);
        tt1.start();
    }
}