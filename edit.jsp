
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<form action="UpdateServlet">
<body>
<center>
<fieldset>
<br>
<label>Applicant Id:</label>
<input type="number" placeholder="id" name="id"><br><br>
<label>First Name:</label>
<input type="text" placeholder="First name" name="fname"><br><br>
<label>Last Name:</label>
<input type="text" placeholder="last name" name="lname"><br><br>
<label>Date of Birth:</label>
<input type="text" placeholder="date of birth" name="date"><br><br>
<label>Qualification:</label>
<select name="choice">
<option>check</option>
<option>Btech</option>
<option>Mtech</option>
<option>BA</option>
<option>Bsc</option>
<option>MBA</option>
<option>MCA</option></select><br><br>
<label>Percentage:</label>
<input type="number" placeholder="percentage"name="percentage"min="0"max="100"><br><br>
<label>Area:</label>
<input type="text" placeholder="area"name="area"><br><br>
<label>Gender:</label>
<input type="radio" name="value" value="male">Male</input>
<input type="radio" name="value" value="female">Female</input><br><br>
<label>Marital Status</label>
<input type="radio" name="var" value="married">Married</input>
<input type="radio" name="var" value="unmarried">Unmarried</input><br><br>
<label >I agree</label>
<input type="checkbox"><br><br>
<button>submit</button>
</fieldset>
</center>
</body>
</form>
</html>