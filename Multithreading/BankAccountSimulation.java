class BankUser implements Runnable {
    private String name;
    private int priority;

    public BankUser(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " checking balance | Priority: " + Thread.currentThread().getPriority());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
        }
    }
}

public class Problem1_BankAccountSimulation {
    public static void main(String[] args) {
        Thread premium = new Thread(new BankUser("Premium User", 10));
        Thread regular = new Thread(new BankUser("Regular User", 5));
        Thread basic = new Thread(new BankUser("Basic User", 1));

        premium.setPriority(10);
        regular.setPriority(5);
        basic.setPriority(1);

        premium.start();
        regular.start();
        basic.start();
    }
}