import java.util.Scanner;
class perimeter_of_rectangle{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the length  ");
        int a=sc.nextInt();
		System.out.print("Enter the breadth  ");
        int b=sc.nextInt();
        int c=2*(a+b);
        System.out.print("The perimeter of rectangle is  "+c);
	}
}	