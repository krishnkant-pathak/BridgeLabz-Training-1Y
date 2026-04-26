import java.util.Scanner;
class tocharArray{
    static char[] chararray(String s){
        char arr[]=new char[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=s.charAt(i);
        }
        return arr;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string  ");
        String s=sc.next();
        char h[]=chararray(s);
        char j[]=s.toCharArray();
        System.out.print("by using charAt  ");
        for(int i=0;i<h.length;i++){
            System.out.print(h[i]);
        }
        System.out.println();
        System.out.print("by using toCharArray  ");
        for(int i=0;i<j.length;i++){
            System.out.print(j[i]);
        }
        System.out.println();
        if(h.length!=j.length){
            System.out.println("Both methods give DIFFERENT results.");
        }
        else{
            for(int i=0;i<h.length;i++){
                if(h[i]!=j[i]){
                    System.out.println("Both methods give DIFFERENT results.");
                    break;
                }
            }
            System.out.println("Both methods give the SAME result.");
        }
    }
}