import java.util.Scanner;
class Positive_Negetive_Zero{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int a=sc.nextInt();
        if(a>0){
            System.out.println("Positive");
        }
        else if(a==0){
            System.out.println("Zero");
        }
        else{
            System.out.println("Negetive");
        }
    }  
}