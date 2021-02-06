<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%! 
String pencil,book,laptop,mobile,pencilcost,bookcost,mobilecost,laptopcost;
int pencilamt=0,bookamt=0,laptopamt=0,mobileamt=0;%>
<% 
//remove all jsp
pencil = request.getParameter("pencil"); 
book = request.getParameter("book") ;
laptop = request.getParameter("laptop"); 
mobile = request.getParameter("mobile");
pencilcost = request.getParameter("pencilcost");
bookcost = request.getParameter("bookcost");
laptopcost = request.getParameter("laptopcost"); 
mobilecost = request.getParameter("mobilecost"); 
%>
<body>

<%
if(pencil != null && !pencil.equals("")){
	pencilamt = Integer.parseInt(pencil)*Integer.parseInt(pencilcost);
	if(session.getAttribute("pencilamt") != null){
		pencilamt += Integer.parseInt(session.getAttribute("pencilamt").toString());
	}
	session.setAttribute("pencilamt", pencilamt + "");
}
if(book != null && !book.equals("")) {
	bookamt = Integer.parseInt(book) * Integer.parseInt(bookcost);
	if(session.getAttribute("bookamt") != null) {
		bookamt = bookamt + Integer.parseInt(session.getAttribute("bookamt").toString());
	}
	session.setAttribute("bookamt", bookamt + ""); // when you add empty string to int it gets converted into string.
}
if(laptop != null && !laptop.equals("")) {
	laptopamt = Integer.parseInt(laptop) * Integer.parseInt(laptopcost);
	if(session.getAttribute("laptopamt") != null) {
		laptopamt = laptopamt + Integer.parseInt(session.getAttribute("laptopamt").toString());
	}
	session.setAttribute("laptopamt", laptopamt + "");
}
if(mobile != null && !mobile.equals("")) {
	mobileamt = Integer.parseInt(mobile) * Integer.parseInt(mobilecost);
	if(session.getAttribute("mobileamt") != null) {
		mobileamt = mobileamt + Integer.parseInt(session.getAttribute("mobileamt").toString());
	}
	session.setAttribute("mobileamt", mobileamt + "");
}
response.sendRedirect("./additem.html");
%>
</body>
</html>