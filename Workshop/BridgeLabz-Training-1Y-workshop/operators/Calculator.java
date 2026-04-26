import java.util.Scanner;
class Calculator{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
System.out.println("enter the 1st number:");
int a=sc.nextInt();
System.out.println("enter the 2nd number:");
int b=sc.nextInt();
int c=a+b;
int d=a-b;
int e=a*b;
double f=a/b;
System.out.println("the sum: "+c);
System.out.println("the difference:"+d);
System.out.println("the product:"+e);
System.out.println("the division:"+f);
}}