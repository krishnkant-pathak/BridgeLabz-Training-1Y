import java.util.Scanner;
class Convert_fahreneit_to_celcius{
    public static double fahreneittocelcius(double a){
        return ((a-32)*5)/9;
    }
    public static double celciustofahreneit(double b){
        return ((b*9)/5)+32;
    }
    public static double poundtokilogram(double c){
        return c*0.453592;
    }
    public static double kilogramtopound(double d){
        return d*2.20462;
    }
    public static double gallontolitre(double e){
        return e*3.78541;
    }
    public static double litretogallon(double f){
        return f*0.264172;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the temperature in fahreneit  ");
        double a=sc.nextDouble();
        System.out.print("Enter the temperature in celcius  ");
        double b=sc.nextDouble();
        System.out.print("Enter the weight in pound  ");
        double c=sc.nextDouble();
        System.out.print("Enter the weight in kilogram  ");
        double d=sc.nextDouble();
        System.out.print("Enter the weight in gallon  ");
        double e=sc.nextDouble();
        System.out.print("Enter the weight in litre  ");
        double f=sc.nextDouble();
        System.out.println(a+" fahreneit to celcius: "+fahreneittocelcius(a));
        System.out.println(b+" celcius to fahreneit: "+celciustofahreneit(b));
        System.out.println(c+" pound to kilogram: "+poundtokilogram(c));
        System.out.println(d+" kilogram to pound: "+kilogramtopound(d));
        System.out.println(e+" gallon to litre: "+gallontolitre(d));
        System.out.println(f+" litre to gallon: "+litretogallon(b));
    }
}