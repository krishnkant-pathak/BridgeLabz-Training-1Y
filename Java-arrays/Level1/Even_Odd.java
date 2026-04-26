import java.util.Scanner;
class Even_Odd{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of inputs   ");
        int a=sc.nextInt();
        if(a>=0){
            int even[]=new int[a],odd[]=new int[a],d=0,e=0;
            for(int i=0;i<a;i++){
                System.out.print("Enter the number  ");
                int b=sc.nextInt();
                if(b%2==0){
                    even[d]=b;
                    d++;
                }
                else{
                    odd[e]=b;
                    e++;
                }
            }
            System.out.println("Even elements are  ");
            for(int i=0;i<d;i++){
                System.out.print(even[i]+" ");
            }
            System.out.println();
            System.out.println("Odd elements are  ");
            for(int i=0;i<e;i++){
                System.out.print(odd[i]+" ");
            }
        }
    }
}