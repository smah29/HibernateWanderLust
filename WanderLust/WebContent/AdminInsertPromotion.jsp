<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="AdminDashBoard.jsp"></jsp:include>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Promotion</title>
</head>
<body>
<c:set var="option" scope="session" value="${option}"/>
<c:out value="${option}"></c:out>
<form action="./AdminPromotion">
<fieldset>
<legend>Fill Flight Details</legend><br><br>
<input type="hidden" name="option" value="insert"/>
<table>

<tr><td>Promotion ID</td><td><input type="text" name="promotionId" placeholder="Enter Promotion Id" required/></td></tr>
<tr><td>Promotion Name</td><td><input type="text" name="promotionName" placeholder="Enter Promotion Name" required/></td></tr>
<tr><td>Discount</td><td><input type="text" name="promotionDiscount" placeholder="Enter Promotion Discount" required/></td></tr>
<tr><td>ExpiryDate</td><td><input type="text" name="promotionExpiryDate" placeholder="Enter Promotion Expiry Date" required/></td></tr>
<tr><td>MinRequiredAmount</td><td><input type="text" name="promotionMinRequiredAmount" placeholder="Enter Promotion MinRequired Amount" required/></td></tr>
<tr><td>Type</td><td><input type="text" name="promotionType" placeholder="Enter Promotion Type" required/></td></tr>

</table>
<input type="submit" value="Insert"/>
</fieldset>
</form>
</body>
</html>