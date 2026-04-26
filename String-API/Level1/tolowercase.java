import java.util.Scanner;
class tolowercase{
    static String lowercase(String s){
        String k="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<=91&&s.charAt(i)>=65){
                k=k+(char)(s.charAt(i)+32);
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
        String h=lowercase(s);
        String j=s.toLowerCase();
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