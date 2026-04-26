import java.util.Scanner;
class Leap_Year_Logical{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year=sc.nextInt();
        if(year>=1582){
            if((year%4==0&&year%100!=0)||year%400==0){
                System.out.println("Year is a Leap Year");
            } 
            else{
                System.out.println("Year is not a Leap Year");
            }
        } 
        else{
            System.out.println("Enter year greater tha 1582");
        }
    }
}
