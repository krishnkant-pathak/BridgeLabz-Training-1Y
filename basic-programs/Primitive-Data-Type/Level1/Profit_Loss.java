class Profit_Loss{
	public static void main(String args[]){
		float cp=129.0f;
		float sp=191.0f;
		float profit=sp-cp;
		float per=(profit/cp)*100;
		System.out.print("The Cost Price is INR "+cp+" and Selling Price is INR "+sp+"\n"+"The Profit is INR "+profit+" and the Profit Percentage is "+per);
	}
}