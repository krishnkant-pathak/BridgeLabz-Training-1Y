import java.util.Scanner;
class Bonus_Salary{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the years of experience  ");
        int a=sc.nextInt();
        System.out.print("Enter the Salary  ");
        int b=sc.nextInt();
        float c;
        if(a>5){
            c=b+(b*0.05f);
        }
        else{
            c=b;
        }
        System.out.println("Your final amount is = "+c);
    }
}