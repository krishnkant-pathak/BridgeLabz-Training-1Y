import java.util.Scanner;
public class All_loops{
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=  sc.nextInt();
    int i=  sc.nextInt();
    int f=  sc.nextInt();
    int e=  sc.nextInt();
    
    int[] arr = new int[e];
    //while
     while (n>0) {
        n--;
        System.out.println(n);
    }
    //dowhile
   do{
System.out.println(i);
i--;}
while(i>0);
//for loop
for(;f>0;f--){
    System.out.println(f);
    //for each 
    
        for (int r = 0; r < e; r++) {
            arr[r] = sc.nextInt();
        }


        for (int x : arr) {
            System.out.println(x);
}
}
}
}
