import java.util.Scanner;
class Positive_Negetive_Zero{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[]=new  int[5];
        for(int i=0;i<5;i++){
            System.out.print("Enter the number  ");
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<5;i++){
            if(arr[i]>0){
                if(arr[i]%2==0){
                    System.out.println("Even");
                }
                else{
                    System.out.println("Odd");
                }
            }
            else if(arr[i]<0){
                System.out.println("Negetive");
            }
            else{
                System.out.println("Zero");
            }
        }
        if(arr[0]>arr[4]){
            System.out.println("Element 1 is greater");
        }
        else if(arr[0]<arr[4]){
            System.out.println("Element 1 is lesser");
        }
        else{
            System.out.println("Both are equal");
        }
    }
}