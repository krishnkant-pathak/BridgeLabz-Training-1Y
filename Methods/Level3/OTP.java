import java.util.Random;
class OTP{
    public static void main(String[] args){
        Random rn=new Random();
        int arr[]=new int[10];
        for(int i=0;i<10;i++){
            arr[i]=rn.nextInt(100000,999999);
        }
        for(int i=0;i<10;i++){
            int a=arr[i];
            for(int j=i+1;j<9;j++){
                if(a==arr[j]){
                    arr[j]=rn.nextInt(100000,999999);
                }
            }
        }
        System.out.print("Your OTP's are ");
        for(int i=0;i<10;i++){
            System.out.print(arr[i]+"   ");
        }
    }
}