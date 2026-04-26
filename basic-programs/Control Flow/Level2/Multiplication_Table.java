import java.util.Scanner;
class Multiplication_Table{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the numebr  ");
        int a=sc.nextInt();
        for(int i=6;i<=9;i++){
            System.out.println(a+" * "+i+" = "+a*i);
        }
    }
}