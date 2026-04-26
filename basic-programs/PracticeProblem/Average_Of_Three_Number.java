import java.util.Scanner;
class average_of_three_number{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the first number  ");
        int a=sc.nextInt();
		System.out.print("Enter the second number  ");
        int b=sc.nextInt();
		System.out.print("Enter the third number  ");
        int c=sc.nextInt();
		float d=(a+b+c)/3;
        System.out.print("The average is  "+d);
	}
}	