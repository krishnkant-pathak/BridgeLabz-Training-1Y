import java.util.Scanner;
class Operation{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int d=a+b*c;
		int e=a*b+c;
		int f=c+a/b;
		int g=a%b+c;
		System.out.print("The result of int operation are "+d+" , "+e+" , "+f+" and "+g);
	}
}