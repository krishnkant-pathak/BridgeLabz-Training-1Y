import java.util.Scanner;

public class BMIProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][3];

        System.out.println("Enter weight (kg) and height (cm) for 10 members:");

        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ":");

            System.out.print("Weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        calculateBMI(data);

        String[] status = getBMIStatus(data);

        System.out.println("\nResults:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) +
                    " -> Height: " + data[i][1] + " cm" +
                    ", Weight: " + data[i][0] + " kg" +
                    ", BMI: " + String.format("%.2f", data[i][2]) +
                    ", Status: " + status[i]);
        }

        sc.close();
    }

    public static void calculateBMI(double[][] data) {

        for (int i = 0; i < data.length; i++) {

            double weight = data[i][0];
            double heightInMeters = data[i][1] / 100.0;

            double bmi = weight / (heightInMeters * heightInMeters);

            data[i][2] = bmi;
        }
    }

    public static String[] getBMIStatus(double[][] data) {

        String[] status = new String[data.length];

        for (int i = 0; i < data.length; i++) {

            double bmi = data[i][2];

            if (bmi < 18.5) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                status[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        return status;
    }
}
