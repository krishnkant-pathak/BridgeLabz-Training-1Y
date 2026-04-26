import java.util.Scanner;
class Power_while{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int a=sc.nextInt();
        System.out.print("Enter the power  ");
        int b=sc.nextInt();
        int num=1;
        while(b>=1){
            num=num*a;
            b=b-1;
        }
        System.out.println("Number = "+num);
    }
}