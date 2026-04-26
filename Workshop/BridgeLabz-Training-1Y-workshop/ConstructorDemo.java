public class ConstructorDemo {
int id;
String name;
int age;

// public ConstructorDemo() {
// System.out.println("Constructor Program");
// }

public ConstructorDemo(int id, String name, int age) {
this.id = id;
this.name = name;
this.age = age;
}


void display(){
System.out.println("ID: "+id);
System.out.println("Name: "+name);
System.out.println("Name: "+age);
}



public static void main(String[] args) {
ConstructorDemo cd = new ConstructorDemo(1,"Jay",25);

// cd.id=1;
// cd.name="kajal";
// cd.age=25;
cd.display();
}
}

// ConstructorDemo cd= new ConstructorDemo(1,"Jay",25);
// System.out.println(cd);
// cd.display();
//
// }
//}