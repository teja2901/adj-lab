import java.rmi.*;
import java.util.*;

public class RMIClient {
	public static void main(String args[]) throws Exception{

		int x,n;
		String result;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of elements:");
		x=sc.nextInt();
		int [] intArray = new int[x];
		System.out.println("Enter elements:");
		for(int i = 0;i < x;i++){
			intArray[i] = sc.nextInt();
		}

		Sort s=(Sort)Naming.lookup("rmi://localhost:1099/sortServer");

		result= s.sorting(intArray);

		System.out.println("After Sorting:"+result);


	}
}