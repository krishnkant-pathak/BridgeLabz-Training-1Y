import java.util.Scanner;
class College_Fees_Input{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		float fee=sc.nextFloat();
		float discount=sc.nextFloat();
		float discount_amount=(fee/100)*discount;
		float finalfee=fee-discount_amount;
		System.out.print("The discount amount is INR "+discount_amount+" and final discounted fee is INR "+finalfee);
	}
}