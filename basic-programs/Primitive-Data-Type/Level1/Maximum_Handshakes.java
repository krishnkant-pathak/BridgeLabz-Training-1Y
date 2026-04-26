import java.util.Scanner;
class Maximum_Handshakes {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int numberOfStudents=sc.nextInt();
        int handshakes=(numberOfStudents*(numberOfStudents-1))/2;
        System.out.print("The maximum number of handshakes among "+numberOfStudents+" students is "+handshakes);
    }
}
