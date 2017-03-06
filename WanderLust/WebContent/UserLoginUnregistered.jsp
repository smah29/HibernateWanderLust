<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="UserDashBoard.jsp"></jsp:include>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:set var="userName" scope="session" value="${user.getUserName()}"/>
<c:if test="${not empty hotelRoomNo}">
   <jsp:forward page="ChoosePromoCodeHotel.jsp" >
   <jsp:param name="hotelId" value="${hotelId}" /> 
   <jsp:param name="hotelRoomNo" value="${hotelRoomNo}" /> 
    </jsp:forward> 
</c:if>
<c:if test="${not empty flightId}">
<jsp:forward page="ChoosePromoCodeFlight.jsp" >
<jsp:param name="flightId" value="${flightId}" /> 

</jsp:forward> 
    
</c:if>
</body>
</html>