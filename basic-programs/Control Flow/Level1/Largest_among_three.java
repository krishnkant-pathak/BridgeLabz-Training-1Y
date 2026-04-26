import java.util.Scanner;
class Largest_among_three{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the first number  ");
        float a=sc.nextFloat();
        System.out.print("Enter the second number  ");
        float b=sc.nextFloat();
        System.out.print("Enter the third number  ");
        float c=sc.nextFloat();
        if(a>=b&&a>=c){
            System.out.println("Is the first number the largest? True");
            System.out.println("Is the second number the largest? false");
            System.out.print("Is the third number the largest? false");
        }
        else if(b>=a&&b>=c){
            System.out.println("Is the first number the largest? false");
            System.out.println("Is the second number the largest? true");
            System.out.print("Is the third number the largest? false");
        }
        else{
            System.out.println("Is the first number the largest? false");
            System.out.println("Is the second number the largest? false");
            System.out.print("Is the third number the largest? true");
        }
    }
}