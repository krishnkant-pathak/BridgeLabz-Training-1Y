package com.gla.thread;

public class MyThread implements Runnable{
    public void run(){
        for (int i=1; i<=10; i++){
            System.out.println("Number : "+i);
        }
    }
    public static void main(String[] args){
        MyThread t1= new MyThread();
        Thread tt1= new Thread(t1);
        tt1.start();
    }
}
