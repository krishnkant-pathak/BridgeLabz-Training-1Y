import java.util.Scanner;
class Frequency{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=sc.nextInt();
        int temp=num;
        int count=0;
        while(temp>0){
            count++;
            temp=temp/10;
        }
        int[] digits=new int[count];
        temp=num;
        int index=0;
        while(temp>0){
            digits[index]=temp%10;
            temp=temp/10;
            index++;
        }
        int[] freq=new int[10];
        for(int i=0;i<count;i++){
            freq[digits[i]]++;
        }
        System.out.println("\nDigit Frequency:");
        for(int i=0;i<10;i++){
            if(freq[i]>0){
                System.out.println("Digit "+i+" occurs "+freq[i]+" time(s)");
            }
        }
    }
}
