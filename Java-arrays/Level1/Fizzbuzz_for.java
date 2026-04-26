import java.util.Scanner;
class Fizzbuzz_for{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        String arr[]=new String[n];
        int c=0;
        if(n>0){
            for(int i=1;i<=n;i++){
                if(i%3==0&&i%5==0){
                    arr[c]="FizzBuzz";
                } 
                else if(i%3==0){
                    arr[c]="Fizz";
                } 
                else if(i%5==0){
                    arr[c]="Buzz";
                } 
                else{
                    arr[c]=String.valueOf(i);
                }
                c++;
            }
        } 
        else{
            System.out.println("Please enter a positive integer.");
        }
        for(int i=0;i<c;i++){
            System.out.print(arr[i]+" ");
        }
    }
}