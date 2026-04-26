import java.util.Scanner;
class Voting{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[]=new  int[10];
        for(int i=0;i<10;i++){
            System.out.print("Enter the age  ");
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<10;i++){
            if(arr[i]>=18){
                System.out.println("The student with the age "+arr[i]+" can vote.");
            }
            else if(arr[i]<0){
                System.out.println("Invalid age ");
            }
            else{
                System.out.println("The student with the age "+arr[i]+" cannot vote.");
            }
        }
    }
}