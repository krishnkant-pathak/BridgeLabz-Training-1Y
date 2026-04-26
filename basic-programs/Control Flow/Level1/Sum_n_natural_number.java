import java.util.Scanner;
class Sum_n_natural_number{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        float a=sc.nextFloat();
        if(a>=0){
            float c=(a*(a+1))/2;
            System.out.print("The sum of "+a+" natural numbers is "+c);
        }
        else{
            System.out.print("The number "+a+" is not a natural number");
        }
    }
}