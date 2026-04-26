import java.util.Scanner;
class Smallesh_Largest{
    public static int largest(int a,int b,int c){
        if(a>b&&a>c){return a;}
        if(b>c&&b>a){return b;}
        return c;

    }
    public static int smallest(int a,int b,int c){
        if(a<b&&a<c){return a;}
        if(b<c&&b<a){return b;}
        return c;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the first number  ");
        int a=sc.nextInt();
        System.out.print("Enter the second number  ");
        int b=sc.nextInt();
        System.out.print("Enter the third number  ");
        int c=sc.nextInt();
        System.out.println("The largest number among three is  "+largest(a,b,c));
        System.out.println("The smallest number among three is  "+smallest(a,b,c));
    }
}