import java.util.Scanner;
class simple_interest{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Principle amount  ");
        int a=sc.nextInt();
		System.out.print("Enter the rate  ");
        int b=sc.nextInt();
		System.out.print("Enter the time  ");
        int c=sc.nextInt();
		float d=(a*b*c)/100;
        System.out.print("The simple interest is  "+d);
	}
}	