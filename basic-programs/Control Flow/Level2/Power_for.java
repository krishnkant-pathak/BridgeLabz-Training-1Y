import java.util.Scanner;
class Power_for{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int a=sc.nextInt();
        System.out.print("Enter the power  ");
        int b=sc.nextInt();
        int num=1;
        for(int i=1;i<=b;i++){
            num=num*a;
        }
        System.out.println("Number = "+num);
    }
}