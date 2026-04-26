import java.util.Scanner;
class Odd_Even{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int a=sc.nextInt();
        System.out.print("Odd  ");
        for(int i=1;i<=a;i=i+2){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.print("Even  ");
        for(int i=2;i<=a;i=i+2){
            System.out.print(i+" ");
        }
    }
}