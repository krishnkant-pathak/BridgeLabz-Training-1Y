import java.util.Scanner;
class Voting_age{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your age  ");
        int a=sc.nextInt();
        if(a>=18){
            System.out.println("The person's age is "+a+" and can vote.");
        }
        else{
            System.out.println("The person's age is "+a+" and cannot vote.");
        }
    }
}