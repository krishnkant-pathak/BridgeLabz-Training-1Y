public class Students {
    
        int id;
        String name;
        int age;
    void DisplayDetails(){
        String status = "Active";
        System.out.println("student id:"+id);
        System.out.println("student name:"+name);
        System.out.println("age:"+age);
        
         System.out.println("status:"+status);
    

      
       
    }
public static void main(String[] args) {
    Students s1=new Students();
s1.DisplayDetails();
}}
