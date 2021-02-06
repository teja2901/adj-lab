import java.util.List;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CSVDataAccess obj = new CSVDataAccess();
		Scanner sc = new Scanner(System.in);
		List<CSVUser> mun = obj.getMunDetails();
		System.out.println("Enter year");
		String yr = sc.next();
		obj.yearwise(mun, yr);
		System.out.println("Enter category");
		String cat = sc.next();
		obj.categorywise(mun, cat);
		
	}


}