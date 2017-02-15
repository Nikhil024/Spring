<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Forgot password?</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<spring:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
   <link href="<spring:url value="/resources/css/login.css"/>" rel="stylesheet" type="text/css">
    <script src="<spring:url value="/resources/js/jquery-1.11.1.min.js"/>"></script>
    <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
</head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round' rel='stylesheet' type='text/css'>
<script src="<spring:url value="/resources/js/jquery.validate.min.js"/>"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

<body>
<div class="text-center" style="padding:50px 0">
	<div class="logo">Forgot Password</div>
	<div class="login-form-1">
		<form id="login-form" class="text-left" action="<spring:url value="/forgotpassword"/>" method="post">
			<div class="login-form-main-message"></div>
			<div class="main-login-form">
				<div class="login-group">
					<div class="form-group">
						<label for="lg_username" class="sr-only">Username</label>
						<input type="text" class="form-control" id="lg_username" name="username" placeholder="username">
					</div>
					<div class="form-group">
						<label for="lg_password" class="sr-only">Password</label>
						<input type="password" class="form-control" id="lg_password" name="password" placeholder="password">
					</div>
					<div class="form-group">
						<label for="lg_password" class="sr-only">Confirm Password</label>
						<input type="password" class="form-control" id="lg_username" name="cpassword" placeholder="Confirm password">
					</div>
					
				</div>
				<button type="submit" class="login-button"><i class="fa fa-chevron-right"></i></button>
			</div>
			<div class="etc-login-form">
				<p>Skip Login? <a href="<spring:url value="/homepage"/>">click here</a></p>
				<p>Know your Credentials? <a href="<spring:url value="/login"/>">Login</a></p>
			</div>
		</form>
	</div>
</div>
<script src="<spring:url value="/resources/js/login.js"/>"/></script>

</body>
</html> --%>


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
<body class="signup-page">
	<nav class="navbar navbar-transparent navbar-absolute">
    	<div class="container">
        	<!-- Brand and toggle get grouped for better mobile display -->
        	<div class="navbar-header">
        		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example">
            		<span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
        		</button>
        		<a class="navbar-brand" href="http://www.creative-tim.com">48Months Flows</a>
        	</div>
    	</div>
    </nav>

    <div class="wrapper">
		<div class="header header-filter" style="background-image: url('<spring:url value="/resources/signup/img/city.jpg"/>'); background-size: cover; background-position: top center;">
			<div class="container">
				<div class="row">
					<div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3">
						<div class="card card-signup">
							<form class="form" action="<spring:url value="/forgotpassword"/>" method="post">
								<div class="header header-primary text-center">
									<h4>Forgot Password</h4>
									<div class="social-line">
										<a href="#pablo" class="btn btn-simple btn-just-icon">
											<i class="fa fa-facebook-square"></i>
										</a>
										<a href="#pablo" class="btn btn-simple btn-just-icon">
											<i class="fa fa-twitter"></i>
										</a>
										<a href="#pablo" class="btn btn-simple btn-just-icon">
											<i class="fa fa-google-plus"></i>
										</a>
									</div>
								</div>
								<div class="content">
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">email</i>
										</span>
										<input type="text" name="username" class="form-control" placeholder="Username">
									</div>

									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">lock_outline</i>
										</span>
										<input type="password" name="password" placeholder="Password" class="form-control" />
									</div>
									
									<div class="input-group">
										<span class="input-group-addon">
											<i class="material-icons">lock_outline</i>
										</span>
										<input type="password" name="cpassword" placeholder="Password" class="form-control" />
									</div>

									<!-- If you want to add a checkbox to this form, uncomment this code

									<div class="checkbox">
										<label>
											<input type="checkbox" name="optionsCheckboxes" checked>
											Subscribe to newsletter
										</label>
									</div> -->
								</div>
								<div class="footer text-center">
									<button type ="submit" class="btn btn-simple btn-primary btn-lg">Get Going..!</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

			<footer class="footer">
		        <!-- <div class="container">
		            <nav class="pull-left">
						<ul>
							<li>
								<a href="http://www.creative-tim.com">
									Creative Tim
								</a>
							</li>
							<li>
								<a href="http://presentation.creative-tim.com">
								   About Us
								</a>
							</li>
							<li>
								<a href="http://blog.creative-tim.com">
								   Blog
								</a>
							</li>
							<li>
								<a href="http://www.creative-tim.com/license">
									Licenses
								</a>
							</li>
						</ul>
		            </nav>
		            <div class="copyright pull-right">
		                &copy; 2016, made with <i class="fa fa-heart heart"></i> by <a href="http://www.creative-tim.com" target="_blank">Creative Tim</a>
		            </div>
		        </div> -->
		    </footer>

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