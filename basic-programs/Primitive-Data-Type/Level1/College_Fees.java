class College_Fees{
	public static void main(String args[]){
		int fees=125000;
		int discount=(125000/100)*10;
		int final_fee=fees-discount;
		System.out.print("The discount amount is INR "+discount+" and final discounted fee is INR "+final_fee);
	}
}