<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="com.mmt.model.bean.Flight"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="AdminDashBoard.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user</title>
<style>
#book{
	border-style: solid;
    border-width: 1px;
    border-color: red;
    background-color: red;
    color: white;
    padding:5px;
    font: bold;
    text-align:center; }
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 19px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}
th {
    background-color: black;
    color: white;
}

tr:hover{background-color:#f5f5f5}

</style>
</head>
<body>
<table border="1">
	<tr>
	<th>UserId</th>
	<th>UserName</th>
	<th>UserPhoneNo</th>
	<th>UserEmailId</th>
	<th>UserAddress</th>
	
	</tr>

<tr>
<c:set var="user" scope="page" value="${userSearched}"/>
<td><c:out value="${user.getUserId()}" /></td>
<td><c:out value="${user.getUserName()}" /></td>
<td><c:out value="${user.getUserPhoneNo()}" /></td>
<td><c:out value="${user.getUserEmailId()}" /></td>
<td><c:out value="${user.getUserAddress()}" /></td>
 
      
  </tr>
 
</table>
</body>
</html>
