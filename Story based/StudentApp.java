class Student {
    int rollNo;
    String name;
    int marks;

    Student(int roll, String name, int marks) {
        this.rollNo = roll;
        this.name = name;
        this.marks = marks;
    }

    String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else return "C";
    }
}

class EngineeringStudent extends Student {
    String branch;

    EngineeringStudent(int roll, String name, int marks, String branch) {
        super(roll, name, marks);
        this.branch = branch;
    }

    String getFullName() {
        return name + " - " + branch;
    }
}

public class StudentApp {
    public static void main(String[] args) {
        EngineeringStudent s = new EngineeringStudent(1, "Aryan", 85, "CSE");
        System.out.println(s.getFullName());
        System.out.println(s.calculateGrade());
    }
}