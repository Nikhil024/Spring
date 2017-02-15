<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <html>
<nav class = "navbar navbar-inverse" role = "navigation">
      <div class = "navbar-header">
      <a class = "navbar-brand" href = ""><img src = "<spring:url value="/resources/images/logo.png"/>" alt = "Generic placeholder thumbnail" height="30" width="50"></a>
   </div>
   
   <div>
      <ul class = "nav navbar-nav ">
		 <li class = "active"><a href = "<spring:url value="/homepage"/>">Flows</a></li>
         <li class = "dropdown">
		 
		  
            <a href = "#" class = "dropdown-toggle" data-toggle = "dropdown">
               Flows List
               <b class = "caret"></b>
            </a>
            
            <ul class = "dropdown-menu">
               <li><a href = "<spring:url value="/homepage"/>">Homepage</a></li>
               <li><a href = "<spring:url value="/orderfreesim"/>">Order free sim</a></li>
               <li><a href = "<spring:url value="/activateafreesim"/>">Activate a Free Sim</a></li>
               <li><a href = "<spring:url value="/download"/>">Downloads</a></li>
               <li><a href = "<spring:url value="/credentials"/>">Credentials</a></li>
            </ul>
         </li>
       <li><a href="<spring:url value="/logout"/>"/><p data-toggle="tooltip" data-placement="bottom" title=" Logged in as <%= session.getAttribute("name") %>">Log out</p></a></li>
      <font color="white"><h1 class="small navbar-text">Last Login : <%= session.getAttribute("lastlogindate") %> </h1></font>
      </ul>
   </div>
  </nav>


<head>

<meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
<script src="<spring:url value="/resources/js/jquery.min.js"/>"/> </script>
<link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>" type="text/css"/>
<link href="<spring:url value="/resources/css/bootstrap-toggle.min.css"/>" rel="stylesheet"/>
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
	<link rel="stylesheet" type="text/css" media="screen" href="<spring:url value="/resources/css/jquery.fancybox-1.3.4.css"/>"/>


<link rel="stylesheet" href="https://www.google.com/fonts#QuickUsePlace:quickUse/Family:Lobster" type="text/css">
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/nik.css"/>"/>
</head>




<body> <!-- oncontextmenu="return false"  -->
<center><h1><b>48 Flows</b></h1></center></font>



<script type="text/javascript" src="<spring:url value="/resources/js/jquery-1.11.0.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/jquery-migrate-1.2.1.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/jquery.fancybox-1.3.4.pack.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/nik.js"/>"></script>
<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
});
</script>

</body>
</html> --%>





<html>
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="<spring:url value="/resources/signup/img/apple-icon.png"/>">
<link rel="icon" type="image/png"
	href="<spring:url value="/resources/signup/img/favicon.png"/>">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Login</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />

<!--     Fonts and icons     -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons" />
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

<!-- CSS Files -->
<link
	href="<spring:url value="/resources/signup/css/bootstrap.min.css"/>"
	rel="stylesheet" />
<link
	href="<spring:url value="/resources/signup/css/material-kit.css"/>"
	rel="stylesheet" />

<meta name="viewport"
	content="width = device-width, initial-scale = 1.0">
<script src="<spring:url value="/resources/js/jquery.min.js"/>" /></script>
<link rel="stylesheet"
	href="<spring:url value="/resources/css/style.css"/>" type="text/css" />
<link
	href="<spring:url value="/resources/css/bootstrap-toggle.min.css"/>"
	rel="stylesheet" />
<script
	src="<spring:url value="/resources/js/bootstrap-toggle.min.js"/>"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap.min.css"/>"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="<spring:url value="/resources/css/bootstrap-theme.min.css"/>"
	integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>

</head>
<body>


	<nav class="navbar .navbar-warning" role="navigation">
	<div class="navbar-header">
		<%-- <a class = "navbar-brand" href = ""><img src = "<spring:url value="/resources/images/logo.png"/>" alt = "Generic placeholder thumbnail" height="30" width="50"></a> --%>
	</div>

	<div>
		<ul class="nav navbar-nav ">
			<li class="active"><a href="<spring:url value="/homepage"/>">Flows</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> Flows List <b class="caret"></b>
			</a>

				<ul class="dropdown-menu">
					<li><a href="<spring:url value="/homepage"/>">Homepage</a></li>
					<li><a href="<spring:url value="/orderfreesim"/>">Order
							free sim</a></li>
					<li><a href="<spring:url value="/activateafreesim"/>">Activate
							a Free Sim</a></li>
					<li><a href="<spring:url value="/download"/>">Downloads</a></li>
					<li><a href="<spring:url value="/credentials"/>">Credentials</a></li>
				</ul></li>
			<li><a href="<spring:url value="/logout"/>" />
			<p data-toggle="tooltip" data-placement="bottom" title=" Logged in as <%= session.getAttribute("name") %>">Log out</p></a></li>
			<font color="black"><h1 class="small navbar-text">
					&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Last Login :
					<%= session.getAttribute("lastlogindate") %>
				</h1></font>
		</ul>
	</div>
	</nav>

</body>
<!--   Core JS Files   -->
<script src="<spring:url value="/resources/signup/js/jquery.min.js"/>"
	type="text/javascript"></script>
<script
	src="<spring:url value="/resources/signup/js/bootstrap.min.js"/>"
	type="text/javascript"></script>
<script src="<spring:url value="/resources/signup/js/material.min.js"/>"></script>

<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script
	src="<spring:url value="/resources/signup/js/nouislider.min.js"/>"
	type="text/javascript"></script>

<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
<script
	src="<spring:url value="/resources/signup/js/bootstrap-datepicker.js"/>"
	type="text/javascript"></script>

<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
<script src="<spring:url value="/resources/signup/js/material-kit.js"/>"
	type="text/javascript"></script>

<script type="text/javascript"
	src="<spring:url value="/resources/js/jquery-1.11.0.min.js"/>"></script>
<script type="text/javascript"
	src="<spring:url value="/resources/js/jquery-migrate-1.2.1.min.js"/>"></script>
<script type="text/javascript"
	src="<spring:url value="/resources/js/jquery.fancybox-1.3.4.pack.min.js"/>"></script>
<script type="text/javascript"
	src="<spring:url value="/resources/js/nik.js"/>"></script>

</html>