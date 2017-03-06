<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="AdminDashBoard.jsp"></jsp:include>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Admin</title>
</head>
<body>
<c:set var="option" scope="session" value="${option}"/>
<c:out value="${option}"></c:out>
<form action="./AdminProfile">
<fieldset>
<legend>Fill Flight Details</legend><br><br>
<input type="hidden" name="option" value="insert"/>
<table>

<tr><td>Admin ID</td><td><input type="text" name="adminId" placeholder="Enter New Admin Id" required/></td></tr>
<tr><td>Admin Name</td><td><input type="text" name="adminName" placeholder="Enter New Admin Name" required/></td></tr>
<tr><td>Admin Phone No</td><td><input type="number" name="adminPhoneNo" placeholder="Enter New Phone No" required/></td></tr>
<tr><td>Admin EmailId</td><td><input type="email" name="adminEmailId" placeholder="Enter New EmailId" required/></td></tr>
<tr><td>Admin Address</td><td><input type="text" name="adminAddress" placeholder="Enter New Address" required/></td></tr>
<tr><td>Admin Password</td><td><input type="text" name="adminPassword" placeholder="Enter New Password" required/></td></tr>

</table>
<input type="submit" value="Add"/>
</fieldset>
</form>
</body>
</html>