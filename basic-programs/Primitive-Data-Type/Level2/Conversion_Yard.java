import java.util.Scanner;
class Conversion_Yard{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        float distanceInFeet = sc.nextFloat();
        float yards=distanceInFeet/3;
        float miles=yards/1760;
        System.out.print("The distance in yard is "+yards+" while the distance in miles "+miles);
    }
}