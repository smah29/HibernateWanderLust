<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="AdminDashBoard.jsp"></jsp:include>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search User</title>
</head>
<body>
<c:set var="option" scope="session" value="${option}"/>
<c:out value="${option}"></c:out>
<form action="./AdminUserProfile">
<fieldset>
<legend>Search User</legend><br><br>
<input type="hidden" name="option" value="search"/>
<table>

<tr><td>User ID</td><td><input type="text" name="userId" placeholder="Enter Id" required/></td></tr>

</table>
<input type="submit" value="Search"/>
</fieldset>
</form>
</body>
</html>