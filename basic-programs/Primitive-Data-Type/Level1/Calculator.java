import java.util.Scanner;
class Calculator{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		float a=sc.nextFloat();
		float b=sc.nextFloat();
		System.out.print("The addition, subtraction, multiplication and division value of 2 numbers "+a+" and "+b+" is "+(a+b)+", "+(a-b)+", "+(a*b)+", and "+(a/b));
	}
}