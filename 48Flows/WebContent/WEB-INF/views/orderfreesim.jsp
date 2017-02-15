<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Order a Free Sim</title>
<meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
<script src="<spring:url value="/resources/js/jquery.min.js"/>"></script> 
<link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>">
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-toggle.min.css"/>">
<script src="<spring:url value="/resources/js/bootstrap-toggle.min.js"/>"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>">

<!-- Optional theme -->
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-theme.min.css"/>">

<!-- Latest compiled and minified JavaScript -->
<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<spring:url value="/resources/js/jquery.min.js"/>"></script>
	<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script>
		$(document).ready(function () {
			$('.dropdown-toggle').dropdown();
		});
		
	</script> 
	<link rel="stylesheet" type="text/css" media="screen" href="<spring:url value="/resources/css/jquery.fancybox-1.3.4.css"/>">


<link rel="stylesheet" href="https://www.google.com/fonts#QuickUsePlace:quickUse/Family:Lobster" type="text/css">
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/nik.css"/>">
</head>
<% if (session.getAttribute("name")!=null){
	%><jsp:include page="logoutheader.jsp"/><%
}
else
{
%> <jsp:include page="loginheader.jsp"/> <%	
}
%>
<body>
<hr/>

<div align="center"><h3><u>Order a Free Sim Flow</u></h3></font>
</div>
<br/>
<div align="center">
<p>To order a Free Sim Goto the <b><a href="http://localhost"><u>48Homepage</u></a></b> and click on the button <b><a href="http://localhost/free-sim"><u>Order a Free Sim</u></a></b>.
<br/>

<hr/>


<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/order_a_sim/orderfreesim1.png"/>" height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><center><h4><a><u>Order a free sim</a></u></h4><p> The buttons for Ordering a freesim in 48 are as shown in Screenshot.</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>




<img class="fancybox" id="float_rig" src="<spring:url value="/resources/images/order_a_sim/orderfreesim3.png"/>"  height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u>
<a href ="<spring:url value="/resources/files/free-sim.phtml"/>" download="free-sim.phtml">Free-sim.phtml</a></u></h4><p>The Details of Order a freesim are being displayed by <b>free-sim.phtml</b> file. </p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/order_a_sim/orderfreesim2.png"/>"  height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a>Order a Free Sim Form</a></u></h4><p>After the Click of the <b>Order a Sim Button</b> a form is displayed where revelant details needs to be filled.</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_rig" src="<spring:url value="/resources/images/order_a_sim/orderfreesim4.png"/>"  height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="<spring:url value="/resources/files/free-sim2.phtml"/>" download="free-sim.phtml">Free-sim.phtml</a></u><br/></h4><p><b>Order a Free Sim Form </b>is being displayed from the <b>free-sim.phtml</b> File.</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/order_a_sim/orderafreesim(logs).png"/>"  height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a>Order a Free Sim Logs</a></u></h4><p>These are the <a href="<spring:url value="/resources/files/orderasim(logs).log"/>" download="orderasim(logs).log"><b>Logs</b></a> generated when <b>Order a Sim Button</b> is clicked i.e when the form is submitted.</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>



<center>
<small>
<ul class = "pagination">
   <li><a href = "">&laquo;</a></li>
   <li><a href = "" disabled="disabled">1</a></li>
   <li><a href = "<spring:url value="/orderfreesim"/>">2</a></li>
   <li><a href = "2.html">&raquo;</a></li>
</ul>
</small>
</center>

<script type="text/javascript" src="<spring:url value="/resources/js/jquery-1.11.0.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/jquery-migrate-1.2.1.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/jquery.fancybox-1.3.4.pack.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/nik.js"/>"></script>
</body>
</html>