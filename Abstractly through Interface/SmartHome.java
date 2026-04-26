interface SmartDevice {
    void turnOn();
    void turnOff();
}

class Light implements SmartDevice {
    public void turnOn() { System.out.println("Light ON"); }
    public void turnOff() { System.out.println("Light OFF"); }
}

class AC implements SmartDevice {
    public void turnOn() { System.out.println("AC ON"); }
    public void turnOff() { System.out.println("AC OFF"); }
}

public class SmartHome {
    public static void main(String[] args) {
        SmartDevice device = new Light();
        device.turnOn();
        device.turnOff();
    }
}