import java.util.Scanner;
class Compare_two_string{
    public static boolean compare(String str1,String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the first string  ");
        String str1=sc.next();
        System.out.print("Enter the second string  ");
        String str2=sc.next();
        boolean a=str1.equals(str2);
        boolean b=compare(str1,str2);
        System.out.println("Result using charAt(): "+b);
        System.out.println("Result using equals(): "+a);
        if(a==b){
            System.out.println("Both methods give the SAME result.");
        } 
        else{
            System.out.println("Both methods give DIFFERENT results.");
        }
    }
}