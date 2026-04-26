package college.main;

import college.student.*;
import college.faculty.*;
import college.department.*;

public class CollegeManagementApp {
    public static void main(String[] args) {
        new Student().display();
        new Faculty().display();
        new Department().display();
    }
}