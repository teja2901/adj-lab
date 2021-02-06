package databases;


import java.sql.*;
import java.io.*;
class Prepared{
	public static void main(String args[]) throws IOException{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			try{
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/employee","root","");
				PreparedStatement pstmt = con.prepareStatement("insert into books values(?,?,?,?)");
				DataInputStream cin = new DataInputStream(System.in);
				int id,cst;
				String bname,authname;
				System.out.println("Enter the book id :");
				id=Integer.parseInt(cin.readLine());
				System.out.println("Enter the name of the book :");
				bname=cin.readLine();
				System.out.println("Enter the author of the book :");
				authname=cin.readLine();
				System.out.println("Enter the cost of the book :");
				cst=Integer.parseInt(cin.readLine());
				pstmt.setInt(1,id);
				pstmt.setString(2,bname);
				pstmt.setString(3,authname);
				pstmt.setInt(4,cst);
				int i = pstmt.executeUpdate();
				if (i==1)
					System.out.println("Information committed");
				else
					System.out.println("Could not commit the information");
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
} 