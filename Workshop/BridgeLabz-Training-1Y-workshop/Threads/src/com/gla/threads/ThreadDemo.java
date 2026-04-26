package com.gla.threads;


class MyThread extends Thread {
    public void run() {
        System.out.println("This is Thread Running");
    }
}


public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
    }
}