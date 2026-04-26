class Contact {
    String name;
    String phoneNumber;

    Contact(String name, String phone) {
        this.name = name;
        this.phoneNumber = phone;
    }

    void display() {
        System.out.println(name + " - " + phoneNumber);
    }
}

class BusinessContact extends Contact {
    String companyName;

    BusinessContact(String name, String phone, String company) {
        super(name, phone);
        this.companyName = company;
    }

    void display() {
        System.out.println(name.toUpperCase() + " - " + phoneNumber + " (" + companyName + ")");
    }
}

public class ContactApp {
    public static void main(String[] args) {
        Contact c = new BusinessContact("Aryan", "9999999999", "TechCorp");
        c.display();
    }
}