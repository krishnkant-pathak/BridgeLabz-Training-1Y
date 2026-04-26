import java.util.Scanner;
class Sum_Enter_0{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int sum=0;
        while(true){
            System.out.print("Enter the number  ");
            int a=sc.nextInt();
            sum=sum+a;
            if(a==0){
                break;
            }
        }
        System.out.print("Sum = "+sum);
    }
}