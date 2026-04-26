import java.util.Scanner;
class Multiple_while{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number=sc.nextInt();
        if(number>0&&number<100){
            int count=number-1;
            while(count>1){
                if(number%count==0){
                    System.out.println(count);
                }
                count--;
            }
        } 
        else{
            System.out.println("Please enter a positive integer less than 100.");
        }
    }
}
    