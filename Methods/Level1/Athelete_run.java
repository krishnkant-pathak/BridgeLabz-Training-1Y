import java.util.Scanner;
class Athelete_run{
    public static double rounds(double a,double b,double c){
        return 5/(a+b+c);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the length of first side   ");
        double a=sc.nextDouble();
        System.out.print("Enter the length of second side   ");
        double b=sc.nextDouble();
        System.out.print("Enter the length of third side   ");
        double c=sc.nextDouble();
        System.out.println("the total number of rounds are  "+rounds(a,b,c));
    }
}