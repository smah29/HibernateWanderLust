<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="UserDashBoard.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details Hotel</title>
<style>
td {
    height: 30px;
    vertical-align: bottom;
}
th, td {
    padding: 5px;
    text-align: left;
}
body{
color:maroon;
}</style>
</head>
<body>
	<form action="./HotelBooking">
<table border="1">		
	<tr><td>		Hotel Name:</td><td>${hotelName}</td></tr>
	<tr><td>	 Room No:</td><td> ${hotelRoomNo}</td></tr>
	<tr><td>	 Location:</td><td>${place}</td></tr>
	<tr><td>	 CheckIn Date: </td><td>${from}</td></tr>
	<tr><td>	 CheckOut Date:</td><td> ${to}</td></tr>
	<tr><td>	 Amount to be paid: </td><td>${finalValuetobepaid}</td></tr>
		<tr><td></td><td> <input type="submit" value="Confirm Hotel Booking"></td></tr>
</table>
	</form>
</body>
</html>