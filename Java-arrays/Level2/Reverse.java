import java.util.Scanner;
class Reverse{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int a=sc.nextInt(),i=0;
        int arr[]=new int[10];
        while(a>=1){
            arr[i]=a%10;
            a=a/10;
            i++;
        }
        System.out.print("Reverse number  "); 
        for(int j=0;j<i;j++){
            System.out.print(arr[j]);
        }
    }
}