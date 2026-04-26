package com.company.main;

import com.company.hr.Employee;
import com.company.payroll.Payroll;

public class CompanyApp {
    public static void main(String[] args) {
        Employee e = new Employee(1, "Aryan", "IT", 50000);
        Payroll p = new Payroll();

        System.out.println("Final Salary: " + p.calculateBonus(e));
    }
}