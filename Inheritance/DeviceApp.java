class Device {
    String deviceId;
    String status;

    Device(String id, String status) {
        this.deviceId = id;
        this.status = status;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId + ", Status: " + status);
    }
}

class Thermostat extends Device {
    int temperatureSetting;

    Thermostat(String id, String status, int temp) {
        super(id, status);
        this.temperatureSetting = temp;
    }

    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature: " + temperatureSetting);
    }
}

public class DeviceApp {
    public static void main(String[] args) {
        Thermostat t = new Thermostat("T101", "ON", 25);
        t.displayStatus();
    }
}