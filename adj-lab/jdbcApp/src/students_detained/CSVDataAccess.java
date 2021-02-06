package students_detained;

//import StudentPOJOClass;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import au.com.bytecode.opencsv.CSVReader;


public class CSVDataAccess {
	public ArrayList readFromStudentCSV(){

	CSVReader reader;
	// Declare ArrayList with POJO generic class.
	ArrayList<StudentPOJOClass> studentList = new <StudentPOJOClass>ArrayList();
	
	try{
		reader = new CSVReader(new FileReader("./student_details.csv"));
		String[] student_data;
		
		while((student_data=reader.readNext())!=null){
			// Declare object from POJO class
			StudentPOJOClass studentPOJO_Obj = new StudentPOJOClass();
			
			
			// call setter methods for each corresponding column index of CSV file. example in the next comment
			// user.setName(newRow[0]);
			
			studentPOJO_Obj.setRegdno(student_data[0]);
			studentPOJO_Obj.setName(student_data[1]);
			
			// add POJO object into arraylist by calling add() method
			studentList.add(studentPOJO_Obj);
			
			
			
		}
		
	}
	catch(Exception e){
		System.out.println(e);
	}
	return studentList;
	}
	
	public ArrayList readFromDetainedCSV(){

		CSVReader reader;
		// Declare ArrayList with POJO generic class.
		ArrayList<StudentPOJOClass> detainedStudentList = new <StudentPOJOClass>ArrayList();
		
		try{
			reader = new CSVReader(new FileReader("./detained_students.csv"));
			String[] detained_students;
			
			while((detained_students=reader.readNext())!=null){
				// Declare object from POJO class
				StudentPOJOClass studentPOJO_Obj = new StudentPOJOClass();
				
				
				// call setter methods for each corresponding column index of CSV file. example in the next comment
				// user.setName(newRow[0]);
				studentPOJO_Obj.setRegdno(detained_students[0]);
				studentPOJO_Obj.setName(detained_students[1]);
				
				// add POJO object into arraylist by calling add() method
				detainedStudentList.add(studentPOJO_Obj);
				
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return detainedStudentList;
		}

}