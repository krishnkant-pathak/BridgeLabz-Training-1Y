import java.util.Scanner;
class Marks2{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of students  ");
        int student=sc.nextInt();
        double overall[][]=new double[student][4];
        String grade[]=new String[student];
        for(int i=0;i<student;i++){
            System.out.println("Enter the marks of "+(i+1)+" student");
            System.out.print("Enter the marks of physics  ");
            overall[i][0]=sc.nextDouble();
            System.out.print("Enter the marks of chemistry  ");
            overall[i][1]=sc.nextDouble();
            System.out.print("Enter the marks of mathematics  ");
            overall[i][2]=sc.nextDouble();
        }
        for(int i=0;i<student;i++){
            overall[i][3]=(overall[i][0]+overall[i][1]+overall[i][2])/3;
        }
        for(int i=0;i<student;i++){
            if(overall[i][3]>=80){
                grade[i]="A";
            }
            else if(overall[i][3]>=70&&overall[i][3]<80){
                grade[i]="B";
            }
            else if(overall[i][3]>=60&&overall[i][3]<70){
                grade[i]="C";
            }
            else if(overall[i][3]>=50&&overall[i][3]<60){
                grade[i]="D";
            }
            else if(overall[i][3]>=40&&overall[i][3]<50){
                grade[i]="E";
            }
            else{
                grade[i]="R";
            }
        }
        for(int i=0;i<student;i++){
            System.out.println("Details of "+(i+1)+" student");
            System.out.println("Physics marks = "+overall[i][0]);
            System.out.println("Chemistry marks = "+overall[i][1]);
            System.out.println("Mathematics marks = "+overall[i][2]);
            System.out.println("Percentage = "+overall[i][3]);
            System.out.println("Status = "+grade[i]);
            System.out.println();
        }
    }
}