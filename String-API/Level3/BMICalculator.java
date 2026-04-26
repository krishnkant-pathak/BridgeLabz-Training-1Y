import java.util.Scanner;

public class BMICalculator {

    public static String[][] calculateBMI(double weight, double heightCm) {

        double heightMeter = heightCm / 100.0;
        double bmi = weight / (heightMeter * heightMeter);
        bmi = Math.round(bmi * 100.0) / 100.0;

        String status;

        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }

        String[][] result = new String[1][4];
        result[0][0] = String.valueOf(heightCm);
        result[0][1] = String.valueOf(weight);
        result[0][2] = String.valueOf(bmi);
        result[0][3] = status;

        return result;
    }

    public static String[][] generateReport(double[][] data) {

        String[][] report = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {

            String[][] temp = calculateBMI(data[i][0], data[i][1]);

            report[i][0] = temp[0][0];
            report[i][1] = temp[0][1];
            report[i][2] = temp[0][2];
            report[i][3] = temp[0][3];
        }

        return report;
    }

    public static void display(String[][] report) {

        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\tStatus");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < report.length; i++) {

            System.out.println((i + 1) + "\t" +
                    report[i][0] + "\t\t" +
                    report[i][1] + "\t\t" +
                    report[i][2] + "\t" +
                    report[i][3]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        String[][] report = generateReport(data);

        display(report);

        sc.close();
    }
}
