<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="UserDashBoard.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UserLogin.jsp">
	<c:set var="flightBooking" scope="session" value="${flightBooking}"/>
	Booking Confirmed!!<br>
	Booking ID: ${flightBooking.getFlightBookingId()}<br><br>
	<input type="submit" value="Okay">
	</form>
</body>
</html>