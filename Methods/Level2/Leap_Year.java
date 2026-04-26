import java.util.Scanner;
class Leap_Year{
    public static boolean isLeapYear(int year){
        if(year<1582){
            return false;
        }
        if((year%4==0&&year%100!=0)||(year%400==0)){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = sc.nextInt();
        if (isLeapYear(year)) {
            System.out.println("Year is a Leap Year");
        } 
        else {
            System.out.println("Year is not a Leap Year");
        }
    }
}
