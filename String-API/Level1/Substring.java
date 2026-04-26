import java.util.Scanner;
class Substring{
    static String sub(String s,int a,int b){
        String d="";
        for(int i=a;i<b;i++){
            d=d+s.charAt(i);
        }
        return d;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string  ");
        String s=sc.next();
        System.out.print("Enter the first index  ");
        int a=sc.nextInt();
        System.out.print("Enter the last index  ");
        int b=sc.nextInt();
        if(a>=0&&a<s.length()&&b>=0&&b<s.length()&&a<=b){
            String h=sub(s,a,b);
            String j=s.substring(a,b);
            System.out.println("by using charAt  "+h);
            System.out.println("by using substring  "+j);
            if(h.equals(j)){
                System.out.println("Both methods give the SAME result.");
            }
            else{
                System.out.println("Both methods give DIFFERENT results.");
            }
        }
        else{
            System.out.println("You entered wrong index");
        }
    }
}