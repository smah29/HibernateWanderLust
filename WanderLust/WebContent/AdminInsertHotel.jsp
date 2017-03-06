<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="AdminDashBoard.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Hotel</title>
</head>
<body>
<form action="./AdminHotel">

<fieldset>
<legend>Fill Hotel Details</legend>
<input type="hidden" name="option" value="insert"/>
<table>
<tr><td>Hotel ID</td><td><input type="text" name="hotelId" placeholder="Enter hotel Id" required/></td></tr>
<tr><td>Name</td><td><input type="text" name="hotelName" placeholder="Enter hotel Name" required/></td></tr>
<tr><td>Location</td><td><input type="text" name="hotelLocation" placeholder="Enter hotel Location" required/></td></tr>
<tr><td>Info</td><td><input type="text" name="hotelInfo" placeholder="Enter hotel Info" required/></td></tr>
</table>
<input type="submit" value="Insert"/>
</fieldset>
</form>
</body>
</html>