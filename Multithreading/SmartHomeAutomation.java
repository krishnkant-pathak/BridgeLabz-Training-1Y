class Device implements Runnable {
    private String name;
    private int interval;

    public Device(String name, int interval) {
        this.name = name;
        this.interval = interval;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " running cycle " + i);
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {}
        }
    }
}

public class Problem2_SmartHomeAutomation {
    public static void main(String[] args) {
        Thread temp = new Thread(new Device("Temperature Sensor", 5000));
        Thread security = new Thread(new Device("Security Camera", 3000));
        Thread light = new Thread(new Device("Light Controller", 4000));
        Thread door = new Thread(new Device("Door Lock", 6000));

        security.setPriority(10);
        temp.setPriority(7);
        light.setPriority(5);
        door.setPriority(5);

        temp.start();
        security.start();
        light.start();
        door.start();
    }
}