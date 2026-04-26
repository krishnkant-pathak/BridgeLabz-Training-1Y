public class ZaraBonusProgram {

    public static void main(String[] args) {

        int employees = 10;

        double[][] employeeData = generateSalaryAndService(employees);

        double[][] updatedData = calculateBonus(employeeData);

        calculateTotals(employeeData, updatedData);
    }

    public static double[][] generateSalaryAndService(int size) {

        double[][] data = new double[size][2]; 
        // column 0 = salary, column 1 = years of service

        for (int i = 0; i < size; i++) {

            int salary = (int)(Math.random() * 90000) + 10000; // 5-digit salary
            int years = (int)(Math.random() * 10) + 1;         // 1 to 10 years

            data[i][0] = salary;
            data[i][1] = years;
        }

        return data;
    }

    public static double[][] calculateBonus(double[][] data) {

        double[][] result = new double[data.length][3];
        // column 0 = old salary
        // column 1 = bonus
        // column 2 = new salary

        for (int i = 0; i < data.length; i++) {

            double salary = data[i][0];
            double years = data[i][1];
            double bonus;

            if (years > 5) {
                bonus = salary * 0.05;
            } else {
                bonus = salary * 0.02;
            }

            double newSalary = salary + bonus;

            result[i][0] = salary;
            result[i][1] = bonus;
            result[i][2] = newSalary;
        }

        System.out.println("Employee Details:");
        System.out.println("Old Salary   Years   Bonus   New Salary");

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%.2f      %.0f      %.2f    %.2f%n",
                    result[i][0],
                    data[i][1],
                    result[i][1],
                    result[i][2]);
        }

        return result;
    }

    public static void calculateTotals(double[][] oldData, double[][] newData) {

        double totalOldSalary = 0;
        double totalBonus = 0;
        double totalNewSalary = 0;

        for (int i = 0; i < oldData.length; i++) {
            totalOldSalary += oldData[i][0];
            totalBonus += newData[i][1];
            totalNewSalary += newData[i][2];
        }

        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus Paid: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);
    }
}
