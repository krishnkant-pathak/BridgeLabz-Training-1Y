import java.util.Scanner;
class Handshakes{
    public static int handshakes(int a){
        return (a*(a-1))/2;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.print("Enter the number of students  ");
        System.out.println("Number of handshakes possible is  "+handshakes(sc.nextInt()));
    }
}