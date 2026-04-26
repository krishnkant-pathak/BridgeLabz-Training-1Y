import java.util.Scanner;
class convert{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the temperature in celcius  ");
		int a=sc.nextInt();
		int c=((a*9)/5)+32;
		System.out.print("The temperature in fahreneit is  "+c);
	}
}