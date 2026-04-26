import java.util.Scanner;
class Spring_Season{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the month  ");
        int a=sc.nextInt();
        System.out.print("Enter the day  ");
        int b=sc.nextInt();
        if(a==3&&b>=20&&b<=31){
            System.out.println("Its a Spring Season");
        }
        else if(a==6&&b>=1&&b<=20){
            System.out.println("Its a Spring Season");
        }
        else if(a>3&&a<6){
            System.out.println("Its a Spring Season");
        }
        else{
            System.out.println("Not a Spring Season");
        }
    }
}