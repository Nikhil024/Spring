<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
<script src="<spring:url value="/resources/js/jquery.min.js"/>"></script> 
<link href="<spring:url value="/resources/css/style.css"/>" rel="stylesheet">
<link href="<spring:url value="/resources/css/bootstrap-toggle.min.css"/>" rel="stylesheet">
<script src="<spring:url value="/resources/js/bootstrap-toggle.min.js"/>"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-theme.min.css"/>" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="<spring:url value="/resources/js/bootstrap.min.js"/>" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

	<script src="<spring:url value="/resources/js/jquery.min.js"/>"></script>
	<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script>
		$(document).ready(function () {
			$('.dropdown-toggle').dropdown();
		});
		
	</script> 
	<link rel="stylesheet" type="text/css" media="screen" href="<spring:url value="/resources/css/jquery.fancybox-1.3.4.css"/>" />


<link rel="stylesheet" href="https://www.google.com/fonts#QuickUsePlace:quickUse/Family:Bungee+Shade" type="text/css">
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/nik.css"/>"/>
<title>Downloads</title>
</head>
<body>
<% if (session.getAttribute("name")==null){
	%><center><h1>You need to be Logged in to visit Downloads page..<br/>Redirecting to Login Page..<br/>Please wait...! <h1></center>
	<script>
	  setTimeout(function() {
	      document.location = "<spring:url value="/login"/>";
	  }, 3000); // 
	</script>
	<!-- <jsp:include page="Login.jsp"/> -->
	<%
}
else
{
%> <jsp:include page="logoutheader.jsp"/> 
<hr/>
<div class = "container">

   <div class = "jumbotron">
      <h1>Welcome to Download page!</h1>
      <p>Download the <b>48codeBase</b> by clicking on the Button below.</p>
      
      <p>
		 <div class="dropdown">
				 <button class="btn btn-primary btn-lg dropdown-toggle" 
				 type="button" id="menu1" data-toggle="dropdown">CodeBase
				 <span class="caret"></span></button>
				 <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
				 <li role="presentation"><a role="menuitem" tabindex="-1" href="<spring:url value="/resources/files/xampp.zip"/>">
				 48Code</a></li>
				 <li role="presentation"><a role="menuitem" tabindex="-1" href="<spring:url value="/resources/files/apache-tomcat-6.0.18.zip"/>">
				 Tomcat</a></li>
				 </ul>
		</div>
		
      </p>
  
</div>
<div class = "jumbotron">
<h1>Instructions:</h1>
<hr/>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1. Install Xampp from <a href="<spring:url value="\\galaxy\Open Source\xampp"/>">Opensource</a> to local <b>C:/</b> Drive </h4>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2. Unzip the contents of xampp folder into <b>C:/</b> Drive </h4>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3. Download the 48Codebase from <a href="https://github.com/48months/48months">GitHub</a> and place it local <b>D:/tools/48Code</b></h4>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4. Download,Unzip and Place the Tomcat Folder in <b>D:/tools</b></h4>
<div>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5. Import the above code in neatbeans and configure Maven and then run the backend code named &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>panda-mvc-layer</b>  on Tomcat.</h4>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 6. Run the Xampp Server and in Borwser type <a href="http://localhost">Localhost</a></h4>
<div>
</body>
</html>
<%
}
%>