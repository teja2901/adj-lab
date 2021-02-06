<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%!
int total;
Enumeration en;
String pencilamt,laptopamt,bookamt,mobileamt,name,value;
%>
<body>
<% 
total = 0; 
en = session.getAttributeNames();
pencilamt = ""; 
laptopamt = "" ;
bookamt = "" ;
mobileamt = "" ;
while(en.hasMoreElements()){
	name = en.nextElement().toString();
	value = session.getAttribute(name).toString();
	total += Integer.parseInt(value);
}
if(session.getAttribute("pencilamt")!= null){
	pencilamt = session.getAttribute("pencilamt").toString();
}
if(session.getAttribute("bookamt") != null) {
	bookamt = session.getAttribute("bookamt").toString();
}
if(session.getAttribute("laptopamt") != null) {
	laptopamt = session.getAttribute("laptopamt").toString();
}
if(session.getAttribute("mobileamt") != null) {
	mobileamt = session.getAttribute("mobileamt").toString();
}
session.invalidate(); 
%>
<table>
<tr><td>Pencil:</td><td><%=pencilamt %></td></tr>
<tr><td>Book:</td><td><%=bookamt %></td></tr>
<tr><td>Laptop:</td><td><%=laptopamt %> </td></tr>
<tr><td>Mobile:</td><td><%=mobileamt %></td></tr>
<tr><td>Total amount:</td><td><%=total %></td></tr>
</table>
</body>
</html>