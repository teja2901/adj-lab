package net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBDataAccess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			// load the jdbc driver-4 into application for mysql.
			Class.forName("com.mysql.jdbc.Driver");
			
			//establish the connection.
			// DriverManager.getConnection(connectionURL, username,password)
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
			
			// Statement object creation.
			
			//Statement stmt= con.createStatement();
			/*String query="insert into emp values(?,?,?,?)";
			PreparedStatement psmt=con.prepareStatement(query);
			
			
			psmt.setString(1, "1657");
			psmt.setString(2, "sarath");
			psmt.setString(3, "8765");
			psmt.setString(4, "admin");
			
			// execution of sql statement. output is table which is represented as resultset in application.
			int rows=psmt.executeUpdate();*/
			
			
			String query="update emp set sal=? where empno=?";
			
			PreparedStatement upsmt=con.prepareStatement(query);
			
			upsmt.setString(1, "18970");
			upsmt.setString(2, "1201");
			
			int rows=upsmt.executeUpdate();
			// retrieve the data from resultset
			System.out.println(rows+" row(s) are updated.");
			
			
			
			Statement stmt=con.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from emp");
			System.out.println("empno\tename\tsal\tdept");
			
			while(rs.next()){
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
			
			con.close();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
   		
		
    }
}