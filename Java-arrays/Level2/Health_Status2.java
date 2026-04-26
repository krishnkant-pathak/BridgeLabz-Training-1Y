import java.util.Scanner;
class Health_Status2{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of persons  ");
        int person=sc.nextInt();
        double overall[][]=new double[person][3];
        String status[]=new String[person];
        for(int i=0;i<person;i++){
            System.out.println("Enter the details of "+(i+1)+" person");
            System.out.print("Enter the height  ");
            overall[i][0]=sc.nextDouble();
            System.out.print("Enter the weight  ");
            overall[i][1]=sc.nextDouble();
        }
        for(int i=0;i<person;i++){
            overall[i][2]=overall[i][1]/(overall[i][0]*overall[i][0]);
        }
        for(int i=0;i<person;i++){
            if(overall[i][2]<=18.4){
                status[i]="Underweight";
            }
            else if(overall[i][2]>=18.5&&overall[i][2]<=24.9){
                status[i]="Normal";
            }
            else if(overall[i][2]>=25&&overall[i][2]<=39.9){
                status[i]="Overweight";
            }
            else if(overall[i][2]>=40){
                status[i]="Obese";
            }
        }
        for(int i=0;i<person;i++){
            System.out.println("Details of "+(i+1)+" person");
            System.out.println("Height = "+overall[i][0]);
            System.out.println("Weight = "+overall[i][1]);
            System.out.println("Body mass index = "+overall[i][2]);
            System.out.println("Status = "+status[i]);
        }
    }
}