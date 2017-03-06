<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="AdminDashBoard.jsp"></jsp:include>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Flight</title>
</head>
<body>
<c:set var="option" scope="session" value="${option}"/>
<c:out value="${option}"></c:out>
<form action="./AdminProfile">
<fieldset>

<input type="hidden" name="option" value="delete"/>
<table>

<tr><td>Admin ID</td><td><input type="text" name="adminId" placeholder="Enter Id" required/></td></tr>

</table>
<input type="submit" value="Delete"/>
</fieldset>
</form>
</body>
</html>