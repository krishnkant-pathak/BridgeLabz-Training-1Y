import java.util.Scanner;
class Greatestfactor_while{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        int i=1,great=1;
        while(i<n){
            if(n%i==0){
                great=i;
            }
            i=i+1;
        }
        System.out.println("Greatest factor is  "+great);
    }
}
