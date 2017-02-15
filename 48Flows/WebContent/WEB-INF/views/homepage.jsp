<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>HomePage</title>
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

<div align="center"><h3><u>Home Page Flow</u></h3></font>
</div>
<br/>
<div align="center">
<p>The main file to open the home page is <b><a href="<spring:url value="/resources/files/index.php"/>" download="index.php">Index.php</a></b> in which all the contents on the  Home page is taken from the file <b><a href="<spring:url value="/resources/files/index.phtml"/>" download="index.phtml">Index.phtml</a></b> .
<br/>

<hr/>


<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/homepage1.png"/>" height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="http://localhost">Localhost</a></u></h4><p>Used to access the <b>48Portal</b> Site locally</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>




<img class="fancybox" id="float_rig"src="<spring:url value="/resources/images/homepage0.png"/>" height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="<spring:url value="/resources/files/index.php"/>" download="Index.php">Index.php</a></u></h4><p>This is the <b>First</b> file being called in the 48CodeBase</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/homepage2.png"/>/" height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="<spring:url value="/resources/files/index.phtml"/>" download="index.phtml">Index.phtml</a></u></h4><p>All the contents of the home page is present in the <b>Index.phtml</b> file</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_rig" src="<spring:url value="/resources/images/HomepageController.png"/>" height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="<spring:url value="/resources/files/HomepageController.php"/>" download="HomepageController.php">HomepageController.php</a></u><br/></h4><p><b>BLAG A FREE MONTH </b>banner is configued in the  controller <b>HomepageController.php</b></p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/homepage2.png"/>" height="150%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="<spring:url value="/resources/files/homepage.css"/>" download="Homepage.css">Homepage.css</a></u></h4><p>The <b>HomepageController.php</b> references the CSS file <b>homepage.css</b> . In the <b>48 Memberships</b> block the background image of <b>48 Membership Plans</b> is being displayed from <b>homepage.css</b> </p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>



<img class="fancybox" id="float_rig"src="<spring:url value="/resources/images/matesrates01.png"/>" height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="<spring:url value="/resources/files/kickback-banner-homepage-sept-2014.phtml"/>" download="Kickback-banner-homepage-sept-2014.phtml">Kickback-banner-homepage-sept-2014.phtml</a></u><br/></h4><p><b>MATES RATES</b> block is displayed from <b>kickback-banner-homepage-sept-2014.phtml</b></p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>



<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/matesrates02.png"/>" height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="<spring:url value="/resources/files/matesrates.css"/>" download="Matesrates.css">Matesrates.css</a></u></h4><p><b>MATES RATES</b> banner is displayed from <b>matesrates.css</b> in the line <b>background-image:url (/css/ux2/images/content-headers/matesrates-homepage.png)</b></p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_rig" src="<spring:url value="/resources/images/help&support.png"/>" height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="<spring:url value="/resources/files/help-and-support-section.phtml"/>" download="Help-and-support-section.phtml">Help-and-support-section.phtml</a></u><br/></h4><p><b>HELP&SUPPORT</b> block is displayed from <b>Help-and-support-section.phtml</b></p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>




<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/help&support03.png"/>" height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="<spring:url value="/resources/files/layout.css"/>" download="Layout.css">Layout.css</a></u></h4><p><b>HELP&SUPPORT</b> banners are displayed from <b>layout.css</b></p></center>
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