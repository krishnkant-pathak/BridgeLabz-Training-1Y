class Employee {
    int empId;
    String name;

    Employee(int id, String name) {
        this.empId = id;
        this.name = name;
    }

    String generateEmail() {
        return name.toLowerCase() + "@company.com";
    }
}

class Manager extends Employee {
    String department;

    Manager(int id, String name, String dept) {
        super(id, name);
        this.department = dept;
    }

    String generateEmail() {
        return name.toLowerCase() + "." + department.toLowerCase() + "@company.com";
    }
}

public class EmployeeApp {
    public static void main(String[] args) {
        Employee e = new Manager(1, "Aryan", "IT");
        System.out.println(e.generateEmail());
    }
}