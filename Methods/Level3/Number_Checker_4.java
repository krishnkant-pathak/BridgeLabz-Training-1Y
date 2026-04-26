import java.util.Scanner;
class Number_Checker_4{
    public static boolean prime(int n){
        int count=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;
            }
        }
        if(count==2){
            return true;
        }
        return false;
    }
    public static boolean neon_number(int z){
        double sum=0,a=z;
        while(z>=1){
            int remain=z%10;
            double b=Math.pow(remain,2);
            sum=sum+b;
            z=z/10;
        }
        if(sum==z){
            return true;
        }
        return false;
    }
    public static boolean spy(int n){
        int sum=0,product=1;
        while(n>=1){
            int remain=n%10;
            sum=sum+remain;
            product=product*remain;
            n=n/10;
        }
        if(product==sum){
            return true;
        }
        return false;
    }
    public static boolean automorphic(int n){
        double f=Math.pow(n,2);
        while(n>=1){
            if(n%10!=f%10){
                return false;
            }
            n=n/10;
            f=f/10;
        }
        return true;
    }
    public static boolean buzz(int n){
        if(n%7==0||n%10==7){
            return true;
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int n=sc.nextInt();
        boolean prime=prime(n);
        boolean neon=neon_number(n);
        boolean spy=spy(n);
        boolean automorphic=automorphic(n);
        boolean buzz=buzz(n);
        System.out.println("Prime number  "+prime);
        System.out.println("Neon number  "+neon);
        System.out.println("Spy number  "+spy);
        System.out.println("Automorphic number  "+automorphic);
        System.out.println("Buzz number  "+buzz);
    }
}