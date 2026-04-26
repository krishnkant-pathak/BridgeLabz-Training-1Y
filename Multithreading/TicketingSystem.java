class Ticket extends Thread {
    private String type;

    public Ticket(String type) {
        this.type = type;
    }

    public void run() {
        try {
            System.out.println(type + " processing started by " + Thread.currentThread().getName());
            Thread.sleep((int)(Math.random() * 5000));
            System.out.println(type + " completed");
        } catch (InterruptedException e) {}
    }
}

public class Problem5_TicketingSystem {
    public static void main(String[] args) {
        String[] types = {"Critical Bug", "Feature Request", "General Query", "Feedback"};

        for (int i = 0; i < 10; i++) {
            Ticket t = new Ticket(types[i % 4]);
            if (types[i % 4].equals("Critical Bug")) t.setPriority(10);
            else if (types[i % 4].equals("Feature Request")) t.setPriority(4);
            else if (types[i % 4].equals("General Query")) t.setPriority(2);
            else t.setPriority(1);

            t.start();
        }
    }
}