import java.util.Scanner;
class Sum_Of_Number{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[10];
        int i=0;
        while(i<10){
            if(i<10){
                System.out.print("Enter the number  ");
                int b=sc.nextInt();
                if(b<=0){
                    break;
                }
                else{
                    arr[i]=b;
                    i++;
                }
            }
        }
        int sum=0;
        for(int j=0;j<i;j++){
            System.out.println(arr[j]);
            sum=sum+arr[j];
        }
        System.out.print("The sum of all elements  "+sum);
    }
}