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
%>
<body>
<%Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3307/db1","root","");
stmt = con.createStatement();
name = request.getParameter("username");
password = request.getParameter("pswd");
query = "insert into login values('"+name+"','"+password+"')";
stmt.executeUpdate(query);
out.println("Data is inserted.");
%>
</body>
</html>