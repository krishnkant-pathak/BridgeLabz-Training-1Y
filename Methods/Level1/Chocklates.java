import java.util.Scanner;
class Chocklates{
    public static int divide(int a,int b){return a/b;}
    public static int remaining(int a,int b){return a%b;}
    public static void main(String[] args) {Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of chocklates  ");int a=sc.nextInt();
        System.out.print("Enter the number of students  ");int b=sc.nextInt();
        System.out.println("The number of chocklates distributed to each student is  "+divide(a,b));
        System.out.println("The remaining chocklates is  "+remaining(a,b));
    }
}