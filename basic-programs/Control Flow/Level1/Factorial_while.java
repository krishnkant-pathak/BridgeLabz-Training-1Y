import java.util.Scanner;
class Factorial_while{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int a=sc.nextInt();
        int fact=1;
        while(a>=1){
            fact=fact*a;
            a=a-1;
        }
        System.out.print("Factorial = "+fact);
    }
}