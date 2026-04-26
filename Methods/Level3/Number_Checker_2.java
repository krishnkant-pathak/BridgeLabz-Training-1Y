import java.util.Scanner;
class Number_Checker_2{
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
    public static int sum(int arr[],int a){
        int sum=0;
        for(int i=0;i<a;i++){
            sum=sum+arr[i];
        }
        return sum;
    }
    public static double sum_square(int arr[],int a){
        double sum=0;
        for(int i=0;i<a;i++){
            double b=Math.pow(arr[i],2);
            sum=sum+b;
        }
        return sum;
    }
    public static boolean harshad(int n,int sum){
        if(n/sum==0){
            return true;
        }
        return false;
    }
    public static int[][] frequency(int n,int b){
        int free[][]=new int[10][2];
        for(int i=0;n>=1;i++){
            free[i][0]=i;
            int digit=n%10;
            free[digit][1]++;
            n=n/10;
        }
        return free;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int n=sc.nextInt();
        int count=count(n);
        int arr[]=store(n,count);
        int sum=sum(arr,count);
        double sum_square=sum_square(arr,count);
        boolean harshad=harshad(n,sum);
        int free[][]=frequency(n,count);
        System.out.println("The total number of digits is  "+count);
        System.out.print("The digits are  ");
        for(int i=0;i<count;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("The sum of all adigits  "+sum);
        System.out.println("The sum of square of each digit  "+sum_square);
        System.out.println("Harshad number  "+harshad);
        System.out.println("Digit Frequencies:");
        for(int i=0;i<10;i++){
            if(free[i][1]>0){
                System.out.println("Digit " + i + " = " + free[i][1] + " times");
            }
        }
    }
}