import java.util.Scanner;
class Rocket_Launch{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int a=sc.nextInt();
        while(a>=0){
            System.out.println(a);
            a=a-1;
        }
    }
}