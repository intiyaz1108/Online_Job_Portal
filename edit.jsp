
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Applicant</title>
</head>
<style>
fieldset{
height:450px;
width:300px;
background-image:linear-gradient(45deg,#f035be,white);
}
body{
background-image:linear-gradient(90deg,white,#f035be);
}</style>

<%
int id=Integer.parseInt(request.getParameter("id"));
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","intiyaz@123");
	Statement s=con.createStatement();
	ResultSet rs=s.executeQuery("select * from details where id="+id);
	while(rs.next()){

%>
<form action="UpdateServlet">
<body>
<center>
<fieldset>
<br>
<label>Applicant Id:</label>
<input type="number" name="id" value="<%=id %>"><br><br>
<label>First Name:</label>
<input type="text" name="fname" value="<%=rs.getString(1) %>"><br><br>
<label>Last Name:</label>
<input type="text" name="lname" value="<%=rs.getString(2) %>"><br><br>
<label>Date of Birth:</label>
<input type="text" name="date" value="<%=rs.getString(3) %>"><br><br>
<label>Qualification:</label>
<select name="choice" value="<%=rs.getString(4) %>">
<option>check</option>
<option>Btech</option>
<option>Mtech</option>
<option>BA</option>
<option>Bsc</option>
<option>MBA</option>
<option>MCA</option></select><br><br>
<label>Percentage:</label>
<input type="number" name="percentage"min="0"max="100" value="<%=rs.getString(5) %>"><br><br>
<label>Area:</label>
<input type="text" name="area" value="<%=rs.getString(6) %>"><br><br>
<label>Gender:</label>
<input type="radio" name="value" value="<%=rs.getString(7) %>">Male</input>
<input type="radio" name="value" value="<%=rs.getString(7) %>">Female</input><br><br>
<label>Marital Status</label>
<input type="radio" name="var" value="married">Married</input>
<input type="radio" name="var" value="unmarried">Unmarried</input><br><br>
<label >I agree</label>
<input type="checkbox"><br><br>
<button>submit</button>
</fieldset>
</center>
<%}
}
catch(Exception e){
	out.println(e);
} %>
</body>
</form>
</html>