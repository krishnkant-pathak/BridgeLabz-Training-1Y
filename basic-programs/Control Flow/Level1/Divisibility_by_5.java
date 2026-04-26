import java.util.Scanner;
class Divisibility_by_5{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        float a=sc.nextFloat();
        if(a%5==0){
            System.out.print("Is the number "+a+" divisible by 5? True");
        }
        else{
            System.out.print("Is the number "+a+" divisible by 5? False");
        }
    }
}