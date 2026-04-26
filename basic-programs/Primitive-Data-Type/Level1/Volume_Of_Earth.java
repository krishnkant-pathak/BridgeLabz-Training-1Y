class Volume_Of_Earth{
	public static void main(String args[]){
		int radius_km=6378;
		float radius_mile=(6378f/1.6f);
		float volume_km=(88f/21f)*radius_km*radius_km*radius_km;
		float volume_mile=(88f/21f)*radius_mile*radius_mile*radius_mile;
		System.out.print("The volume of earth in cubic kilometers is "+volume_km+" and cubic miles is "+volume_mile);
	}
}