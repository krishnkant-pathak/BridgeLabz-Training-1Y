import java.util.Scanner;
class Voting{
    public static boolean checker(int a){
        if(a<18){
            return false;
        }
        else{
            return true;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[10];
        for(int i=0;i<10;i++){
            System.out.print("Enter the age  ");
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<10;i++){
            System.out.println("Student "+(i+1)+" can vote or not  "+checker(arr[i]));
        }
    }
}