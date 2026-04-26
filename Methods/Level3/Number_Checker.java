import java.util.Scanner;
class Number_Checker{
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
    public static boolean duck(int n){
        while(n>=1){
            if(n%10==0){
                return true;
            }
            n=n/10;
        }
        return false;
    }
    public static boolean armstrong(int a,int b){
        int sum=0,c=a;
        while(a>=1){
            int remain=a%10;
            int h=1;
            for(int i=0;i<b;i++){
                h=h*remain;
            }
            sum=sum+h;
            a=a/10;
        }
        if(sum==c){
            return true;
        }
        return false;
    }
    public static int[] largest(int arr[],int b){
        int arr2[]=new int[2];
        arr2[0]=arr[0];
        arr2[1]=0;
        for(int i=0;i<b;i++){
            if(arr2[0]<arr[i]){
                arr2[1]=arr2[0];
                arr2[0]=arr[i];
            }
            else if(arr[i]>arr2[1]&&arr[i]!=arr2[0]) {
                arr2[1]=arr[i];
            }
        }
        return arr2;
    }
    public static int[] smallest(int arr[],int b){
        int arr2[]=new int[2];
        arr2[0]=arr[0];
        arr2[1]=0;
        for(int i=0;i<b;i++){
            if(arr2[0]>arr[i]){ 
                arr2[1]=arr2[0];
                arr2[0]=arr[i];
            }
            else if(arr[i]<arr2[1]&&arr[i]!=arr[0]){
                arr2[1]=arr[i];
            }
        }
        return arr2;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int n=sc.nextInt();
        int count=count(n);
        int arr[]=store(n,count);
        boolean duck=duck(n);
        boolean armstrong=armstrong(n,count);
        int arr2[]=largest(arr,count);
        int arr3[]=smallest(arr,count);
        System.out.println("The total number of digits is  "+count);
        System.out.print("The digits are  ");
        for(int i=0;i<count;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("Duck number  "+duck);
        System.out.println("Armstrong number  "+armstrong);
        System.out.println("The largest digit is  "+arr2[0]+" and the Second largest digit is  "+arr2[1]);
        System.out.println("The smallest digit is  "+arr3[0]+" and the Second smallest digit is  "+arr3[1]);
    }
}