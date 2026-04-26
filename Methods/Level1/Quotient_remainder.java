import java.util.Scanner;
class Quotient_remainder{
    public static int quotient(int a,int b){return a/b;}
    public static int remainder(int a,int b){return a%b;}
    public static void main(String[] args) {Scanner sc=new Scanner(System.in);
        System.out.print("Enter the numerator  ");int a=sc.nextInt();
        System.out.print("Enter the denominator  ");int b=sc.nextInt();
        System.out.println("The quotient is  "+quotient(a,b));
        System.out.println("The remainder is  "+remainder(a,b));
    }
}