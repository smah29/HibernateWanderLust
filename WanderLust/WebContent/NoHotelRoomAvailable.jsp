<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="BlackHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>No Hotel Rooms Available</title>
</head>
<body>
<% String msg=(String)session.getAttribute("message"); %>
<h1 style="color: red"><% out.print(msg); %></h1><br><br>

</body>
</html>