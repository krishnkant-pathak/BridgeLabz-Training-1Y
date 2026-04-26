import java.util.Scanner;
class Number_Checker_5{
    public static boolean perfect(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                sum=sum+i;
            }
        }
        if(sum==n){
            return true;
        }
        return false;
    }
    public static boolean abundant(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                sum=sum+i;
            }
        }
        if(sum>n){
            return true;
        }
        return false;
    }
    public static boolean deficient(int n){
        int sum=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                sum=sum+i;
            }
        }
        if(sum<n){
            return true;
        }
        return false;
    }
    public static boolean strong(int n){
        int sum=0,a=n;
        while(n>=1){
            int remain=n%10;
            for(int i=remain;i>=1;i--){
                remain=remain*i;
            }
            sum=sum+remain;
            n=n/10;
        }
        if(sum==a){
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int n=sc.nextInt();
        boolean perfect=perfect(n);
        boolean abundant=abundant(n);
        boolean deficient=deficient(n);
        boolean strong=strong(n);
        System.out.println("Perfect number  "+perfect);
        System.out.println("Abundant number  "+abundant);
        System.out.println("Deficient number  "+deficient);
        System.out.println("Strong number  "+strong);
    }
}