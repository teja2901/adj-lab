import java.util.ArrayList;
public class ArrayListExample {
 public static void main(String args[]) {
 ArrayList<String> obj = new ArrayList<String>();
 obj.add("Ajeet");
 obj.add("Harry");
 obj.add("Chaitanya");
 obj.add("Steve");
 obj.add("Anuj");
 System.out.println("Currently the array list has following elements:"+obj);
 obj.add(0, "Rahul");
 obj.add(1, "Justin");
 obj.remove("Chaitanya");
 obj.remove("Harry");
 System.out.println("Current array list is:"+obj);
 obj.remove(1);
 System.out.println("Current array list is:"+obj);
 }
} 
