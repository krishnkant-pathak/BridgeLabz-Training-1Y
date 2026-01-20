import java.util.*;
class Calculator{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the first number  ");
        int a=sc.nextInt();
        System.out.print("Enter the second number  ");
        int b=sc.nextInt();
		System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.print("You entered wrong symbol");
        
    }
}