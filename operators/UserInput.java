import java.util.Scanner;
class UserInput{
public static void main(String[]args){
Scanner sc= new Scanner(System.in);
System.out.println("enter the array size");

int n=sc.nextInt();
int marks[]=new int[n];
System.out.println("enter the array element");
for(int i=0;i<n;i++){
marks[i]=sc.nextInt();
}
System.out.println("enter the array element");
for(int i=0;i<n;i++){

System.out.println(" "+marks[i]);}
}
}






