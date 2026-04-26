import college.student.Student;
import college.faculty.Faculty;

public class CollegeApp {
    public static void main(String[] args) {
        Student s = new Student("Aryan", 101);
        Faculty f = new Faculty("Dr. Sharma", "Java");

        s.display();
        f.display();
    }
}