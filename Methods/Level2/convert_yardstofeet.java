import java.util.Scanner;
class convert_yardstofeet{
    public static double yardstofeet(double a){
        return a*3;
    }
    public static double feettoyards(double b){
        return b*0.333333;
    }
    public static double metertoinches(double c){
        return c*39.3701;
    }
    public static double inchestometer(double d){
        return d*0.0254;
    }
    public static double inchestocm(double d){
        return d*2.54;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the distance in yards  ");
        double a=sc.nextDouble();
        System.out.print("Enter the distance in feet  ");
        double b=sc.nextDouble();
        System.out.print("Enter the distance in meter  ");
        double c=sc.nextDouble();
        System.out.print("Enter the distance in inches  ");
        double d=sc.nextDouble();
        System.out.println(a+" yards to feet: "+yardstofeet(a));
        System.out.println(b+" feet to yards: "+feettoyards(b));
        System.out.println(c+" meter to inches: "+metertoinches(c));
        System.out.println(d+" inches to meter: "+inchestometer(d));
        System.out.println(d+" inches to cm: "+inchestocm(d));
    }
}