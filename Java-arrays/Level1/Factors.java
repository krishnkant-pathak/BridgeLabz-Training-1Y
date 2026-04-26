import java.util.Scanner;
class Factors{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int a=sc.nextInt();
        int arr[]=new int[a],b=0;
        for(int i=1;i<=a;i++){
            if(a%i==0){
                arr[b]=i;
                b++;
            }
        }
        System.out.println("Factors are  ");
        for(int i=0;i<b;i++){
            System.out.print(arr[i]+" ");
        }
    }
}