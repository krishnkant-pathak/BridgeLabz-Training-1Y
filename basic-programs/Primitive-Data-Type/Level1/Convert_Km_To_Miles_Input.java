import java.util.Scanner;
class Convert_Km_To_Miles_Input{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		float km=sc.nextFloat();
		float mile=km/1.6f;
		System.out.print("The total miles is "+mile+" mile for the given "+km+" km");
	}
}