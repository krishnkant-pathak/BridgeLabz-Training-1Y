import java.util.Scanner;
class Positive_negetive_zero{
    public static int nature(int a){
        if(a>0)return 1;
        else if(a<0)return -1;
        return 0;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        System.out.println("the number is  "+nature(sc.nextInt()));
    }
}