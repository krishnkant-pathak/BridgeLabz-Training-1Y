import java.util.Scanner;
class area_of_circle{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the radius of circle  ");
        int a=sc.nextInt();
        int c=(22/7)*a*a;
        System.out.print("The area of circle is  "+c);
	}
}	