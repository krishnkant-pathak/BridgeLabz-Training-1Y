import java.util.Scanner;
class Youngest_Tallest{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter thne age of Amar  ");
        int a=sc.nextInt();
        System.out.print("Enter thne age of Akbar  ");
        int b=sc.nextInt();
        System.out.print("Enter thne age of Anthony  ");
        int c=sc.nextInt();
        System.out.print("Enter thne height of Amar  ");
        int d=sc.nextInt();
        System.out.print("Enter thne height of Akbar  ");
        int e=sc.nextInt();
        System.out.print("Enter thne height of Anthony  ");
        int f=sc.nextInt();
        if(a<=b&&a<=c){
            System.out.println("Amar is youngest");
        }
        else if(b<=a&&b<=c){
            System.out.println("Akbar is youngest");
        }
        else{
            System.out.println("Anthony is youngest");
        }
        if(d>=e&&d>=f){
            System.out.println("Amar is tallest");
        }
        else if(e>=d&&e>=f){
            System.out.println("Akbar is tallest");
        }
        else{
            System.out.println("Anthony is tallest");
        }
    }
}