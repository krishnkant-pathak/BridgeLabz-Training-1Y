import java.util.Scanner;

public class MarksCalculatorProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Physics marks: ");
        double physics = sc.nextDouble();

        System.out.print("Enter Chemistry marks: ");
        double chemistry = sc.nextDouble();

        System.out.print("Enter Maths marks: ");
        double maths = sc.nextDouble();

        double total = physics + chemistry + maths;
        double average = total / 3;
        double percentage = (total / 300) * 100;

        String grade;
        String remarks;

        if (percentage >= 90) {
            grade = "A";
            remarks = "Excellent";
        } else if (percentage >= 75) {
            grade = "B";
            remarks = "Very Good";
        } else if (percentage >= 60) {
            grade = "C";
            remarks = "Good";
        } else if (percentage >= 50) {
            grade = "D";
            remarks = "Average";
        } else {
            grade = "F";
            remarks = "Fail";
        }

        System.out.println("\n----- Result -----");
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
    }
}
