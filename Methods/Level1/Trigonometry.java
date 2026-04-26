import java.util.Scanner;
class Trigonometry{
    public static double[] Functions(double angle){
        double radians=Math.toRadians(angle);
        double[] result={Math.sin(radians),Math.cos(radians),Math.tan(radians)};
        return result;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle=sc.nextDouble();
        double[] values=Functions(angle);
        System.out.println("Sin="+values[0]);
        System.out.println("Cos="+values[1]);
        System.out.println("Tan="+values[2]);
    }
}