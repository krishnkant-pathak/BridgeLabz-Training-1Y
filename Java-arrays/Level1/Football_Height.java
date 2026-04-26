import java.util.Scanner;
class Football_Height{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        double arr[]=new double[11];
        for(int i=0;i<11;i++){
            System.out.print("Enter the height of the footballer  ");
            arr[i]=sc.nextDouble();
        }
        double mean=0;
        for(int i=0;i<11;i++){
            mean=mean+arr[i];
        }
        mean=mean/11.0;
        System.out.println("Mean of average football player is  "+mean);
    }
}