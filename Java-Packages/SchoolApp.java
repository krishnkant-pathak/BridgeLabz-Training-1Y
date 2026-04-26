package com.school.main;

import com.school.data.*;
import com.school.util.*;

public class SchoolApp {
    public static void main(String[] args) {
        Student s = new Student("Aryan", 85, 90, 80);
        Analyzer a = new Analyzer();

        double avg = a.calculateAverage(s);
        System.out.println(s);
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + a.findGrade(avg));
    }
}