import java.util.Scanner;
class Largest{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number  ");
        int a=sc.nextInt(),i=0;
        int arr[]=new int[10];
        while(a>1&&i<10){
            arr[i]=a%10;
            a=a/10;
            i++;
        }
        int largest=0,secondlargest=0;
        for(int j=0;j<i;j++){
            if(arr[j]>largest){
                secondlargest=largest;
                largest=arr[j];
            }
            else if(arr[j]>secondlargest && arr[j]!=largest){
                secondlargest=arr[j];
            }
        }
        System.out.println("Largest number  "+largest);
        System.out.println("Second largest number  "+secondlargest);
    }
}