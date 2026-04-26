import java.util.Scanner;
class convert_km_to_miles{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the distance in kilometer  ");
		int a=sc.nextInt();
		double c=a*(0.621371);
		System.out.print("The distance in miles  "+c);
	}
}