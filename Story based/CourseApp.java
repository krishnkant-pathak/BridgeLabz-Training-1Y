class Course {
    int courseId;
    String courseName;
    double price;
    static String platformName = "LearnHub";

    Course(int id, String name, double price) {
        this.courseId = id;
        this.courseName = toTitleCase(name);
        this.price = price;
    }

    double getFinalPrice() {
        return price;
    }

    String toTitleCase(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }

    void display() {
        System.out.println(platformName + " | " + courseName + " | " + getFinalPrice());
    }
}

class RecordedCourse extends Course {
    RecordedCourse(int id, String name, double price) {
        super(id, name, price);
    }

    double getFinalPrice() {
        return price * 0.9;
    }
}

class LiveCourse extends Course {
    LiveCourse(int id, String name, double price) {
        super(id, name, price);
    }

    double getFinalPrice() {
        return price * 0.95;
    }
}

public class CourseApp {
    public static void main(String[] args) {
        Course c1 = new RecordedCourse(1, "java programming", 1000);
        Course c2 = new LiveCourse(2, "data science", 1000);

        c1.display();
        c2.display();
    }
}