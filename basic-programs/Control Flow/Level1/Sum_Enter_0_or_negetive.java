import java.util.Scanner;
class Sum_Enter_0_or_negetive{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int sum=0;
        while(true){
            System.out.print("Enter the number  ");
            int a=sc.nextInt();
            if(a<=0){
                break;
            }
            sum=sum+a;
        }
        System.out.print("Sum = "+sum);
    }
}