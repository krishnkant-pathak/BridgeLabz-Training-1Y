import java.util.Scanner;
class Sumupton{
    public static int sum(int a){
        return (a*(a+1))/2;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        System.out.println("Sum  =  "+sum(sc.nextInt()));
    }
}