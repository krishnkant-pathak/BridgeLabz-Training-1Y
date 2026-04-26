import java.util.Scanner;
class Convert_2Dto1D{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of rows  ");
        int a=sc.nextInt();
        System.out.print("Enter the number of columns  ");
        int b=sc.nextInt();
        int arr[][]=new int[a][b],arr2[]=new int[a*b],c=0;
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                System.out.print("Enter the number  ");
                arr[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                arr2[c]=arr[i][j];
                c++;
            }
        }
        System.out.println("Elements are  ");
        for(int i=0;i<a*b;i++){
            System.out.print(arr2[i]+" ");
        }
    }
}