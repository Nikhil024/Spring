<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="<spring:url value="/resources/signup/img/apple-icon.png"/>">
	<link rel="icon" type="image/png" href="<spring:url value="/resources/signup/img/favicon.png"/>">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Login</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

	<!--     Fonts and icons     -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons" />
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

	<!-- CSS Files -->
    <link href="<spring:url value="/resources/signup/css/bootstrap.min.css"/>" rel="stylesheet" />
    <link href="<spring:url value="/resources/signup/css/material-kit.css"/>" rel="stylesheet"/>
    <style>
body {
   background-color: white;
     }
</style>

    </head>
<body>


<div class="col-sm-4">
	<div class="form-group">	
    	<input type="text" value="" name="myTextBox" placeholder="Regular" class="form-control" onchange="demo()"/>
	</div>
</div>




<div class="col-sm-4">
	<div class="form-group label-floating has-success">
		<label class="control-label">Success input</label>
		<input type="text" value="de" class="form-control" />
		<span class="form-control-feedback">
			<i class="material-icons">done</i>
		</span>
	</div>
</div>

<div class="col-sm-4">
	<div class="form-group label-floating has-success">
		<label class="control-label">Success input</label>
		<input type="text" value="de" class="form-control" />
		<span class="form-control-feedback">
			<i class="material-icons">done</i>
		</span>
	</div>
</div>
</body>
	<!--   Core JS Files   -->
	<script src="<spring:url value="/resources/signup/js/jquery.min.js"/>" type="text/javascript"></script>
	<script src="<spring:url value="/resources/signup/js/bootstrap.min.js"/>" type="text/javascript"></script>
	<script src="<spring:url value="/resources/signup/js/material.min.js"/>"></script>

	<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
	<script src="<spring:url value="/resources/signup/js/nouislider.min.js"/>" type="text/javascript"></script>

	<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
	<script src="<spring:url value="/resources/signup/js/bootstrap-datepicker.js"/>" type="text/javascript"></script>

	<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
	<script src="<spring:url value="/resources/signup/js/material-kit.js"/>" type="text/javascript"></script>

</html>
 