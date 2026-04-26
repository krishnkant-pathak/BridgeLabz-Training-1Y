import java.util.Scanner;

public class StudentMarks {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = generateMarks(n);

        System.out.println("\nStudent Results:");
        System.out.println("Phy  Chem  Math  Total  Average  Percentage");

        for (int i = 0; i < n; i++) {

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            System.out.printf("%3d  %4d  %4d  %5d  %7.2f  %9.2f%n",
                    marks[i][0], marks[i][1], marks[i][2],
                    total, average, percentage);
        }

        sc.close();
    }

    public static int[][] generateMarks(int n) {

        int[][] scores = new int[n][3];

        for (int i = 0; i < n; i++) {

            scores[i][0] = (int)(Math.random() * 90) + 10; // Physics
            scores[i][1] = (int)(Math.random() * 90) + 10; // Chemistry
            scores[i][2] = (int)(Math.random() * 90) + 10; // Maths
        }

        return scores;
    }
}
