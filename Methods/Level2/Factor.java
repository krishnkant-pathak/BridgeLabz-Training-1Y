import java.util.Scanner;
class Factor{
    public static int count(int a){
        int count=0;
        for(int i=1;i<=a;i++){if(a%i==0){count++;}}
        return count;
    }
    public static int[] fact(int a,int b){
        int arr[]=new int[b],y=0;
        for(int i=1;i<=a;i++){if(a%i==0){arr[y]=i;y++;}}
        return arr;
    }
    public static int[] sum(int arr[],int b){
        int sum=0,sumsquare=0,product=1,arr2[]=new int[3];
        for(int i=0;i<b;i++){
            sum=sum+arr[i];
            sumsquare=sumsquare+(arr[i]*arr[i]);
            product=product*arr[i];}
        arr2[0]=sum;arr2[1]=sumsquare;arr2[2]=product;
        return arr2;
    }
    public static void display(int arr[],int b,int arr2[]){
        System.out.print("Factors are  :-  ");
        for(int i=0;i<b;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("Sum of factors  "+arr2[0]);
        System.out.println("Sum of square of factors  "+arr2[1]);
        System.out.println("Product of factors  "+arr2[2]);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int a=sc.nextInt(),b=count(a),arr[]=fact(a,b),arr2[]=sum(arr,b);
        display(arr,b,arr2);
    }
}