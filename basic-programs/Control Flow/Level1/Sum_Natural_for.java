import java.util.Scanner;
class Sum_Natural_for{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int a=sc.nextInt();
        int sum1=(a*(a+1))/2;
        int sum2=0;
        for(int i=0;i<=a;i++){
            sum2=sum2+i;
        }
        System.out.println("As we see both results are same ");
    }
}