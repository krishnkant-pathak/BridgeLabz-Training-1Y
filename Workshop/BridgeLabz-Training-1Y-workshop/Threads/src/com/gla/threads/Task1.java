package com.gla.threads;

class Task1 extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Task 1 (Low Priority) - " + i);
        }
    }
}

class Task2 extends Thread {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Task 2 (Medium Priority) - " + i);
        }
    }
}

class Task3 extends Thread {
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println("Task 3 (High Priority) - " + i);
        }
    }
}

// ❗ Removed 'public' (IMPORTANT)
class MainThreadExample {
    public static void main(String[] args) throws InterruptedException {

        Task1 t1 = new Task1();
        Task2 t2 = new Task2();
        Task3 t3 = new Task3();

        t1.setName("Thread-LOW");
        t2.setName("Thread-MEDIUM");
        t3.setName("Thread-HIGH");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        // Controlled execution using join()
        t3.start();
        t3.join();

        t2.start();
        t2.join();

        t1.start();
        t1.join();
    }
}