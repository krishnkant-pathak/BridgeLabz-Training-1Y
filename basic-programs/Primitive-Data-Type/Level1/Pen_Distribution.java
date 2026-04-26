class Pen_Distribution{
	public static void main(String args[]){
		int number_of_pens=14;
		int students=3;
		int per_student=number_of_pens/students;
		int remain=number_of_pens%students;
		System.out.print("The Pen Per Student is "+per_student+" and the remaining pen not distributed is "+remain);
	}
}