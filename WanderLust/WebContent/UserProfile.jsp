<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="UserDashBoard.jsp"></jsp:include>

	
<div class="container">
  
  <div class="panel panel-primary">
    <div class="panel-heading">Profile details</div>
    <div class="panel-body">
    userId: ${user.getUserId() } <br>
	userName: ${user.getUserName() } <br>
	userPhoneNo: ${user.getUserPhoneNo() } <br>
	userEmailId: ${user.getUserEmailId() } <br>
	userAddress: ${user.getUserAddress() }<br>
    
    </div>
  </div>
</div>

</body>
</html>