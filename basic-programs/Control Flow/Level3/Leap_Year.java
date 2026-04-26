import java.util.Scanner;
class Leap_Year{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year=sc.nextInt();
        if(year>=1582){
            if(year%400==0){
                System.out.println("Year is a Leap Year");
            }
            else if(year%100==0){
                System.out.println("Year is not a Leap Year");
            }
            else if(year%4==0){
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
