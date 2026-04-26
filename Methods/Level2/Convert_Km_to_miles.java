import java.util.Scanner;
class Convert_Km_to_miles{
    public static double kmtomiles(double a){
        return a*0.621371;
    }
    public static double milestokm(double b){
        return b*1.60934;
    }
    public static double metertofeet(double c){
        return c*3.28084;
    }
    public static double feettometer(double d){
        return d*0.3048;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the distance in km  ");
        double a=sc.nextDouble();
        System.out.print("Enter the distance in miles  ");
        double b=sc.nextDouble();
        System.out.print("Enter the distance in meter  ");
        double c=sc.nextDouble();
        System.out.print("Enter the distance in feet  ");
        double d=sc.nextDouble();
        System.out.println(a+" km to miles: "+kmtomiles(a));
        System.out.println(b+" miles to km: "+milestokm(b));
        System.out.println(c+" meter to feet: "+metertofeet(c));
        System.out.println(d+" feet to meter: "+feettometer(d));
    }
}