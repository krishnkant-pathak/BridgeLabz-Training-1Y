import java.util.Scanner;
class Factors_array{
    public static int[] factors(int n){
        int count=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;
            }
        }
        int arr[]=new int[count],j=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                arr[j]=i;
                j++;
            }
        }
        return arr;
    }
    public static int sum(int arr[]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        return sum;
    }
    public static int product(int arr[]){
        int product=1;
        for(int i=0;i<arr.length;i++){
            product=product*arr[i];
        }
        return product;
    }
    public static double cube(int arr[]){
        double product=1;
        for(int i=0;i<arr.length;i++){
            double j=Math.pow(arr[i],3);
            product=product*j;
        }
        return product;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int n=sc.nextInt();
        int arr[]=factors(n);
        int sum=sum(arr);
        int product=product(arr);
        double cube=cube(arr);
        System.out.print("Factors are  ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("The greatest factor is  "+arr[arr.length-2]);
        System.out.println("The sum of the factors are  "+sum);
        System.out.println("The product of the factors are  "+product);
        System.out.println("The product of the cube of the factors are  "+cube);
    }
}