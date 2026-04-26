import java.util.Scanner;
class Height_Conversion{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		float height=sc.nextFloat();
		float inch=height/2.54f;
		float feet=inch/12f;
		System.out.print("Your Height in cm is "+height+" while in feet is "+feet+" and inches is "+inch);
	}
}