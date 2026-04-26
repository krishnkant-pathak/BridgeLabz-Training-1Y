import java.util.Scanner;
class Even{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i=0;i<=n;i++){
            if(i % 2 == 0){
                continue;}
        System.out.println(i);
        

    }
    }}