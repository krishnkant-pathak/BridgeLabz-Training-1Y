import java.util.Scanner;
class Multiplication_Table{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        System.out.print("Enter the number  ");
        int a=sc.nextInt();
        for(int i=0;i<10;i++){
            arr[i]=arr[i]*a;
        }
        for(int i=0;i<10;i++){
            System.out.println(a+" * "+(i+1)+" = "+arr[i]);
        }
    }
}