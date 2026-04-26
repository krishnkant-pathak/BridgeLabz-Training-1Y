import java.util.Scanner;
class Health_Status{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of persons  ");
        int person=sc.nextInt();
        double height[]=new double[person],weight[]=new double[person],bmi[]=new double[person];
        String status[]=new String[person];
        for(int i=0;i<person;i++){
            System.out.println("Enter the details of "+(i+1)+" person");
            System.out.print("Enter the height  ");
            height[i]=sc.nextDouble();
            System.out.print("Enter the weight  ");
            weight[i]=sc.nextDouble();
        }
        for(int i=0;i<person;i++){
            bmi[i]=weight[i]/(height[i]*height[i]);
        }
        for(int i=0;i<person;i++){
            if(bmi[i]<=18.4){
                status[i]="Underweight";
            }
            else if(bmi[i]>=18.5&&bmi[i]<=24.9){
                status[i]="Normal";
            }
            else if(bmi[i]>=25&&bmi[i]<=39.9){
                status[i]="Overweight";
            }
            else if(bmi[i]>=40){
                status[i]="Obese";
            }
        }
        for(int i=0;i<person;i++){
            System.out.println("Details of "+(i+1)+" person");
            System.out.println("Height = "+height[i]);
            System.out.println("Weight = "+weight[i]);
            System.out.println("Body mass index = "+bmi[i]);
            System.out.println("Status = "+status[i]);
        }
    }
}