//swap
int a = 10, b = 20;
int temp = a;
a = b;
b = temp;
//swap without third variable
int a = 10, b = 20;
a = a + b; // 30
b = a - b; // 10
a = a - b; // 20
//reverse
int n = 1234;
int rev = 0;

while (n > 0) {
    int rem = n % 10;
    rev = rev * 10 + rem;
    n = n / 10;
}
System.out.println(rev);
//count digits
int n = 93840;
int count = 0;

while (n > 0) {
    count++;
    n /= 10;
}
System.out.println(count);
//armstrong
import java.util.Scanner;

class ArmstrongNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int original = num;
        int sum = 0;
        int digits = 0;
        int temp = num;

        // Count digits
        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        temp = num;

        // Calculate Armstrong sum
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }

        // Check
        if (sum == original) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }
    }
}


if (sum == temp)
    System.out.println("Armstrong");
else
    System.out.println("Not Armstrong");

int n = 29;
boolean prime = true;

for (int i = 2; i <= n / 2; i++) {
    if (n % i == 0) {
        prime = false;
        break;
    }
}

System.out.println(prime ? "Prime" : "Not Prime");
