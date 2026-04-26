import java.util.Scanner;
class Simple_Interest{
    public static double simpleinterest(double a,double b,double c){
        double si=(a*b*c)/100;
        return si;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the principle amount  ");
        double principle=sc.nextDouble();
        System.out.print("Enter the rate of interest  ");
        double rate=sc.nextDouble();
        System.out.print("Enter the time  ");
        double time=sc.nextDouble();
        double si=simpleinterest(principle,rate,time);
        System.out.println("The Simple Interest is "+si+" for Principal "+principle+", Rate of Interest "+rate+" and Time "+time);
    }
}