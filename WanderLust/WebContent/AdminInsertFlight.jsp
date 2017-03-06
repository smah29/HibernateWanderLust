<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="AdminDashBoard.jsp"></jsp:include>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Flight</title>
</head>
<body>
<c:set var="option" scope="session" value="${option}"/>
<c:out value="${option}"></c:out>
<form action="./AdminFlight">
<fieldset>
<legend>Fill Flight Details</legend><br><br>
<input type="hidden" name="option" value="insert"/>
<table>

<tr><td>Flight ID</td><td><input type="text" name="flightId" placeholder="Enter Id" required/></td></tr>
<tr><td>Company Name</td><td><input type="text" name="flightCompanyName" placeholder="Enter CompanyName" required/></td></tr>
<tr><td>Source</td><td><input type="text" name="flightSource" placeholder="Enter Source" required/></td></tr>
<tr><td>Destination</td><td><input type="text" name="flightDestination" placeholder="Enter Destination" required/></td></tr>
<tr><td>Depart</td><td><input type="text" name="flightDepartureTime" placeholder="Enter DepartureTime" required/></td></tr>
<tr><td>Arrive</td><td><input type="text" name="flightArrivalTime" placeholder="Enter ArrivalTime" required/></td></tr>
<tr><td>Ticket Price</td><td><input type="text" name="flightTicketPrice" placeholder="Enter TicketPrice" required/></td></tr>
<tr><td>Total Seats</td><td><input type="number" name="availableSeats" placeholder="Enter Total Seats" required/></td></tr>
</table>
<input type="submit" value="Insert"/>
</fieldset>
</form>
</body>
</html>