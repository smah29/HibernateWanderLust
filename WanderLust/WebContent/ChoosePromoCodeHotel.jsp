<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="UserDashBoard.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose Promo</title>
<script>
	function loadDoc() {
		/* var xhttp;
		 if (window.XMLHttpRequest) {
		  // code for modern browsers
		   xhttp = new XMLHttpRequest();
		   } else {
		   // code for IE6, IE5
		   xhttp = new ActiveXObject("Microsoft.XMLHTTP");
		 }
		 xhttp.onreadystatechange = function() {
		   if (this.readyState == 4 && this.status == 200) {
		     document.getElementById("demo").innerHTML = this.responseText;
		   }
		 };
		 xhttp.open("GET", "hotelPromo.txt", true);
		 xhttp.send();*/
		document.getElementById("demo").innerHTML = "Congrats! You got a discount of "
				+ '${pdiscountHotel}'
				+ "%<br>Your Promotion ID is "
				+ ' ${pidHotel}';
				
	}
</script>
<style>
#applyPromo, #continue {
	border-style: solid;
	border-width: 1px;
	border-color: red;
	background-color: red;
	color: white;
	padding: 5px;
	font: bold;
	text-align: center;
}
</style>
</head>
<body>
	<form action="./PaymentHotel">


		<p>
			<b>Select a Promo Code</b>&nbsp; &nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select id="promohotel"
				name="promohotel">

				<!--<c:set var="flightPromo" scope="session" value="${arrayListPromoFlight}"/>-->
				<c:forEach items="${arrayListPromoHotel}" var="hotelPromo">
					
					<option value="${hotelPromo.getPromotionId()}">${hotelPromo.getPromotionName()}</option>

					<c:set var="pidHotel" scope="session"

			

						value="${hotelPromo.getPromotionId()}" />

					<c:set var="pdiscountHotel" scope="session"

					

						value="${hotelPromo.getPromotionDiscount()}" />
				</c:forEach>
			</select> &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; <input type="button"
				id="applyPromo" value="Apply" onclick="loadDoc()" />
		</p>
		<br>
		<p id="demo"></p>

		<p>
			<input type="submit" id="continue" value="Pay Now" />
		</p>

	</form>
</body>
</html>