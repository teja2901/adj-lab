package students_detained;

import java.util.ArrayList;

public class StudentApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create readfromcsvfile object
		CSVDataAccess studentData = new CSVDataAccess();
		
		// call readfromcsvfile() and get arraylist object
		ArrayList<StudentPOJOClass> studentList = studentData.readFromStudentCSV();
		ArrayList<StudentPOJOClass> detainedstudentList = studentData.readFromDetainedCSV();
		
		
		// create object from dboperation object
		StudentDBOperations dbOperations	= new StudentDBOperations();
		
		// call insertRows() by passing arraylist object and get integer and display no of rows inserted done.
		// call selectquery() to display query results
		
		int rows1 = dbOperations.studentsInsertion(studentList);
		System.out.println("rows inserted in student table : "+rows1);
		
		int rows2 = dbOperations.detainedStudentsInsertion(detainedstudentList);
		System.out.println("rows inserted in detained student table : "+rows2);
		System.out.println("Deleted "+rows2 +" rows from student table as the students are detained and transferred to detained student table");
		
		
		dbOperations.detainedStudentDetails();
		dbOperations.studentDetails();
		

	}

}