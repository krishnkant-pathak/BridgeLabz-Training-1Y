import java.util.Scanner;
class Marks{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of student  ");
        int student=sc.nextInt();
        double physics[]=new double[student],chemistry[]=new double[student],mathematics[]=new double[student],percentage[]=new double[student];
        String grade[]=new String[student];
        for(int i=0;i<student;i++){
            System.out.println("Enter the details of "+(i+1)+" student");
            System.out.print("Enter the physics  ");
            physics[i]=sc.nextDouble();
            System.out.print("Enter the chemistry  ");
            chemistry[i]=sc.nextDouble();
            System.out.print("Enter the mathematics  ");
            mathematics[i]=sc.nextDouble();
        }
        for(int i=0;i<student;i++){
            percentage[i]=(chemistry[i]+mathematics[i]+physics[i])/3;
        }
        for(int i=0;i<student;i++){
            if(percentage[i]>=80){
                grade[i]="A";
            }
            else if(percentage[i]>=70&&percentage[i]<80){
                grade[i]="B";
            }
            else if(percentage[i]>=60&&percentage[i]<70){
                grade[i]="C";
            }
            else if(percentage[i]>=50&&percentage[i]<60){
                grade[i]="D";
            }
            else if(percentage[i]>=40&&percentage[i]<50){
                grade[i]="E";
            }
            else{
                grade[i]="R";
            }
        }
        for(int i=0;i<student;i++){
            System.out.println("Details of "+(i+1)+" student");
            System.out.println("Physics marks = "+physics[i]);
            System.out.println("Chemistry marks = "+chemistry[i]);
            System.out.println("Mathematics marks = "+mathematics[i]);
            System.out.println("Percentage = "+percentage[i]);
            System.out.println("grade = "+grade[i]);
            System.out.println();
        }
    }
}