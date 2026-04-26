import java.util.Scanner;
class Rocket_Launch_for{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int a=sc.nextInt();
        for(int i=a;i>=0;i--){
            System.out.println(i);
        }
    }
}