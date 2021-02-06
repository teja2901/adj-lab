<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.lang.*" %>
<%@ page import = "java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%!String name;
String password;
String query;
Connection con = null;
Statement stmt = null;
//PreparedStatement psmt;
ResultSet rs;
//PrintWriter out = null;
%>
<body>
<%Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3307/db1","root","");
stmt = con.createStatement();
name = request.getParameter("username");
password = request.getParameter("pswd");
query = "select * from login where username = '"+name+"'and password = '" +password+"'";
rs = stmt.executeQuery(query);
if(rs.next()){
	%>
	<h3>You have logged in successfully..!!</h3>
	<%
}
else{
	%>
	<h3>You are not an Authenticated user.</h3>
	<% 
}
%>
</body>
</html>