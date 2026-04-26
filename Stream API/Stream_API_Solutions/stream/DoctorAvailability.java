import java.util.*;

class Doctor {
    String name;
    String day;
    String specialty;

    Doctor(String name, String day, String specialty) {
        this.name = name;
        this.day = day;
        this.specialty = specialty;
    }
}

public class DoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr A", "Saturday", "Cardiology"),
            new Doctor("Dr B", "Monday", "Dermatology"),
            new Doctor("Dr C", "Sunday", "Neurology")
        );

        doctors.stream()
            .filter(d -> d.day.equals("Saturday") || d.day.equals("Sunday"))
            .sorted((d1, d2) -> d1.specialty.compareTo(d2.specialty))
            .forEach(d -> System.out.println(d.name));
    }
}
