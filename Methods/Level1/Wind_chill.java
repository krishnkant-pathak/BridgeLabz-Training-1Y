import java.util.Scanner;
class Wind_chill{
    public static double windchill(double a,double b){return (35.74+(0.6215*a)+(((0.4275*a)-35.75)*b));}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the temperature  ");double temp=sc.nextDouble();
        System.out.print("Enter the wind speed  ");double speed=sc.nextDouble();
        System.out.println("The wind chill is  "+windchill(temp,speed));
    }
}