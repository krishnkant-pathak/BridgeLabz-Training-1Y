import java.util.Scanner;
class Number_Checker_3{
    public static int count(int n){
        int count=0;
        while(n>=1){
            count++;
            n=n/10;
        }
        return count;
    }
    public static int[] store(int n,int a){
        int arr[]=new int[a];
        for(int i=0;i<a;i++){
            int remain=n%10;
            arr[i]=remain;
            n=n/10;
        }
        return arr;
    }
    public static int reverse(int n){
        int sum=0;
        while(n>=1){
            sum=(sum*10)+n%10;
            n=n/10;
        }
        return sum;
    }
    public static boolean compare(int arr1[],int arr2[]){
        int a=arr1.length;
        int b=arr2.length;
        if(a==b){
            for(int i=0;i<a;i++){
                if(arr1[i]!=arr2[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public static boolean pallindrome(int a,int b){
        if(a==b){
            return true;
        }
        return false;
    }
    public static boolean duck(int n){
        while(n>=1){
            if(n%10==0){
                return true;
            }
            n=n/10;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int n=sc.nextInt();
        int count=count(n);
        int arr[]=store(n,count);
        int reverse=reverse(n);
        boolean pallindrome=pallindrome(n,reverse);
        boolean duck=duck(n);
        System.out.println("The total number of digits is  "+count);
        System.out.print("The digits are  ");
        for(int i=0;i<count;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("The reverse of the number is  "+reverse);
        System.out.println("Pallindrome  "+pallindrome);
        System.out.println("Duck  "+duck);
    }
}