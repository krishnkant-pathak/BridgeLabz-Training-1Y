import java.util.Scanner;
class Remainder_Quotient{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		int div=sc.nextInt();
		System.out.print("The Quotient is "+number/div+" and Remainder is "+number%div+"of two number "+number+" and "+div);
	}
}