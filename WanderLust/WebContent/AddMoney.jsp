<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="UserDashBoard.jsp"></jsp:include>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Money</title>
<script>

function check(){
	
	
	
	
	
	var demo = document.getElementById("demo"), msgFlight,moneyRequired;
	msgFlight = demo.getAttribute("data_messageFlight");
	moneyRequired = demo.getAttribute("moneyRequired");
	if(msgFlight !=null){
	if(document.getElementById("amount").value < moneyRequired ){
		alert("Please Enter the Required Amount");
	}}
	
}
</script>
</head>
<body>
<form action="./MoneyAddded">
<c:choose>
<c:when test="${not empty messageFlight}">
${messageFlight}   
</c:when>
<c:when test="${not empty messageHotel}">
${messageHotel}   
</c:when>

</c:choose> 

<fieldset>

Amount&nbsp;&nbsp;  :&nbsp; &nbsp; <input type="number" min="0" required="required" placeholder="Enter Amount"  id="amount" name="amount" onblur="check();"/><br>
<input type="submit" value="Add" id="add" >

<div id ="demo"  data_messageFlight=${messageFlight} moneyRequired=${moneyToBeAdded}></div>
</fieldset>
<br>
<br>
</form>
</body>
</html>