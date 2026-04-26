import java.util.Scanner;
class add{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter first number  ");
		int a=sc.nextInt();
		System.out.print("Enter the second number  ");
		int b=sc.nextInt();
		int c=a+b;
		System.out.print("The sum of two numbers is  :-  "+c);
	}
}