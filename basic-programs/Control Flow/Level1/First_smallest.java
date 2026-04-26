import java.util.Scanner;
class First_smallest{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the first number  ");
        float a=sc.nextFloat();
        System.out.print("Enter the second number  ");
        float b=sc.nextFloat();
        System.out.print("Enter the third number  ");
        float c=sc.nextFloat();
        if(a<=b&&a<=c){
            System.out.print("Is the first number the smallest? True");
        }
        else{
            System.out.print("Is the first number the smallest? False");
        }
    }
}