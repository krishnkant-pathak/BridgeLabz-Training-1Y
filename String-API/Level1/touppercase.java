import java.util.Scanner;
class touppercase{
    static String uppercase(String s){
        String k="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<=123&&s.charAt(i)>=97){
                k=k+(char)(s.charAt(i)-32);
            }
            else{
                k=k+(s.charAt(i));
            }
        }
        return k;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string  ");
        String s=sc.nextLine();
        String h=uppercase(s);
        String j=s.toUpperCase();
        System.out.println("by using charAt  "+h);
        System.out.println("by using toLowerCase  "+j);
        if(h.equals(j)){
            System.out.println("Both methods give the SAME result.");
        }
        else{
            System.out.println("Both methods give DIFFERENT results.");
        }
    }
}