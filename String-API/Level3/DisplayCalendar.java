import java.util.Scanner;

public class DisplayCalendar {

    public static int getFirstDay(int m, int y) {

        int m0 = m;
        int y0 = y;

        if (m < 3) {
            m0 = m + 12;
            y0 = y - 1;
        }

        int x = y0 + y0/4 - y0/100 + y0/400;
        int d0 = (1 + x + (31 * m0) / 12) % 7;

        return d0;
    }

    public static int getDaysInMonth(int m, int y) {

        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            return 31;
        }

        if (m == 4 || m == 6 || m == 9 || m == 11) {
            return 30;
        }

        if (m == 2) {
            if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
                return 29;
            } else {
                return 28;
            }
        }

        return 0;
    }

    public static void displayCalendar(int m, int y) {

        int firstDay = getFirstDay(m, y);
        int days = getDaysInMonth(m, y);

        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= days; day++) {

            System.out.printf("%3d ", day);

            if ((firstDay + day) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter year: ");
        int year = sc.nextInt();

        displayCalendar(month, year);

        sc.close();
    }
}
