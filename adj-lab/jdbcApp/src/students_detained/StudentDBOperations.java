package students_detained;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.PreparedStatement;

//import com.mysql.jdbc.PreparedStatement;


public class StudentDBOperations {
	
	public Connection getDBConnection(){
		Connection con=null;
		try {
			// load the jdbc driver-4 into application for mysql.
			
			Class.forName("com.mysql.jdbc.Driver");
			
			//establish the connection.
			// DriverManager.getConnection(connectionURL, username,password)
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/adjlab","root","");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	
	public void closeDBConnection(Connection con){
		try
        {
            con.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	}
	
	public int studentsInsertion(ArrayList<StudentPOJOClass> studentList){
		int rows=0;
		try{
			Connection con=getDBConnection();
			//create insert query relevent to your application with ? instead of values 
			String query="insert into students values(?,?)";
			
			PreparedStatement psmt=con.prepareStatement(query);
			
			// Create object of Iterator from ArrayList and then iterate through
			
			Iterator<StudentPOJOClass> it=studentList.iterator();
			
			while(it.hasNext()){
				// Create POJO object from it.next
				StudentPOJOClass student=it.next();
				// call setXXX() methods to set the values with the values of POJO class members by calling its getter in place of each ?
				
				psmt.setString(1, student.getRegdno());
				psmt.setString(2, student.getName());
				rows +=psmt.executeUpdate();
			}
	      closeDBConnection(con);
		}
		catch(Exception e){
			e.printStackTrace();
		}
				
		return rows;
	}
	public int detainedStudentsInsertion(ArrayList<StudentPOJOClass> detainedStudentList){
		int rows=0;
		try{
			Connection con=getDBConnection();
			String insertQuery="insert into detained_students values(?,?)";
			PreparedStatement psmt1=con.prepareStatement(insertQuery);
			
			// Create object of Iterator from ArrayList and then iterate through
			
			Iterator<StudentPOJOClass> it=detainedStudentList.iterator();
			while(it.hasNext()){
				StudentPOJOClass detainedStudents=it.next();
				
				String regdno = detainedStudents.getRegdno();
				String name = detainedStudents.getName();
				String selectQuery="SELECT * FROM students where regdno =? and name = ?";
				PreparedStatement psmt2=con.prepareStatement(selectQuery);
				psmt2.setString(1, regdno);
				psmt2.setString(2, name);
				ResultSet rs = psmt2.executeQuery();
				int count = 0;
				while(rs.next()) {
					count = 1;
				}
				if(count == 1) {
					
					psmt1.setString(1, regdno);
					psmt1.setString(2, name);
					rows +=psmt1.executeUpdate();
					
					String deleteQuery = "DELETE FROM students WHERE regdno = ? and name = ?";
					PreparedStatement psmt3 = con.prepareStatement(deleteQuery);
					psmt3.setString(1, regdno);
					psmt3.setString(2, name);
					psmt3.executeUpdate();
				}
			}
			closeDBConnection(con);
		}
		catch(Exception e){
			e.printStackTrace();
		}
				
		return rows;
 	}
	
	// define selectqueryN () for each select query in the problem statement. 
	
	public void studentDetails()
	// Parameter list as per your requirement to set the values into select query
	{
		try{
			// prepare select query relevant to your requirement with ? .
			String query="SELECT * FROM students"; 
			Connection con=getDBConnection();
			PreparedStatement psmt=con.prepareStatement(query);
			
			// call psmt.setXXX() methods to set the values into all ? in query.
			
			// execute query
			ResultSet result=psmt.executeQuery();
			System.out.println("\nStudent Details:\nREGDNO\tNAME");
			while(result.next()) {
				System.out.println(result.getString(1)+"\t"+result.getString(2));
			}
			
			// Iterate rs to show results of query
			//statement object creation
			
			closeDBConnection(con);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void detainedStudentDetails()
	{
		try{
			String query="SELECT * FROM detained_students"; 
			Connection con=getDBConnection();
			PreparedStatement psmt=con.prepareStatement(query);
			ResultSet result=psmt.executeQuery();
			System.out.println("\nDetained students Details:\nREGDNO\tNAME");
			while(result.next()) {
				System.out.println(result.getString(1)+"\t"+result.getString(2));
			}
			closeDBConnection(con);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}