import java.util.Scanner;
class Multiplication_6to_9{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enteer the number  ");
        int a=sc.nextInt();
        int arr[]={6,7,8,9};
        for(int i=0;i<=3;i++){
            arr[i]=arr[i]*a;
        }
        for(int i=0;i<=3;i++){
            System.out.println(a+" * "+(i+6)+" = "+arr[i]);
        }
    }
}