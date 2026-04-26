import java.util.Scanner;
class Sum_natural_number{
    public static int formula(int a){
        int sum=(a*(a+1))/2;
        return sum;
    }
    public static int recur(int a){
        if(a==0){
            return 0;
        }
        int sum=a+recur(a-1);
        return sum;
    }
    public static void main(String argsp[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int a=sc.nextInt(),formul=0,recu=0;
        if(a>=1){
            formul=formula(a);
            recu=recur(a);
        }
        else{
            System.out.println("You enteresd wrong number");
        }
        System.out.println("By formula  "+formul);
        System.out.println("By recursive method  "+recu);
        if(formul==recu){
            System.out.print("Both methods to find sum is correct");
        }
        else{
            System.out.print("They both mathods are different");
        }
    }
}