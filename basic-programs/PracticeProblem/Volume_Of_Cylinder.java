import java.util.Scanner;
class volume_of_cylinder{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the radius of cylinder  ");
        int a=sc.nextInt();
		System.out.print("Enter the height of cylinder  ");
        int b=sc.nextInt();
        int c=(22/7)*a*a*b;
        System.out.print("The volume of cylinder is  "+c);
	}
}	