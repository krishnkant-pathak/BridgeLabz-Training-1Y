import java.util.Random;
class Football_Team{
    public static int sum(int arr[]){
        int sum=0;
        for(int i=0;i<11;i++){
            sum=sum+arr[i];
        }
        return sum;
    }
    public static double mean(int a){
        double mean=a/11;
        return mean;
    }
    public static int tallest(int arr[]){
        int tall=arr[0];
        for(int i=1;i<11;i++){
            if(tall<arr[i]){
                tall=arr[i];
            }
        }
        return tall;
    }
    public static int small(int arr[]){
        int small=arr[0];
        for(int i=1;i<11;i++){
            if(small>arr[i]){
                small=arr[i];
            }
        }
        return small;
    }
    public static void main(String args[]){
        Random random=new Random();
        int height[]=new int[11];
        for(int i=0;i<11;i++){
            height[i]=random.nextInt(150,250);
        }
        int a=sum(height);
        double b=mean(a);
        int tall=tallest(height);
        int sm=small(height);
        System.out.println("The sum of heights of player  "+a);
        System.out.println("The average height of each player  "+b);
        System.out.println("The tallest player is of height  "+tall);
        System.out.println("The smallest player  height is  "+sm);
    }
}