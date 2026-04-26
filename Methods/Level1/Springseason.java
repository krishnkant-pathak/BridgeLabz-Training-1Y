import java.util.Scanner;
class Springseason{
    public static boolean spring(int a,int b){
        if(a>=4&&a<=5){if(b>=1&&b<=31){return true;}}
        else if(a==3){if(b>=20&&b<=31){return true;}}
        else if(a==6){if(b>=1&&b<=20){return true;}}
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the month  ");
        int a=sc.nextInt();
        System.out.print("Enter the day  ");
        int b=sc.nextInt();
        System.out.println(spring(a,b));
    }
}