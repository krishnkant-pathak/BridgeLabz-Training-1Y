import java.util.Scanner;
class Greatestfactor_for{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        int great=1;
        for(int i=1;i<n;i++){
            if(n%i==0){
                great=i;
            }
        }
        System.out.println("Greatest factor is  "+great);
    }
}
