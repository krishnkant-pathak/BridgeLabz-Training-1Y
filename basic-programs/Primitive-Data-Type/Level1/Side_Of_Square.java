import java.util.Scanner;
class Side_Of_Square{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        float perimeter=sc.nextFloat();
        float side=perimeter/4;
        System.out.print("The length of the side is " +side+" whose perimeter is "+perimeter);
    }
}