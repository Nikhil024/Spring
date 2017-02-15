<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="<spring:url value="/resources/img/apple-icon.png"/>">
<link rel="icon" type="image/png"
	href="<spring:url value="/resources/img/favicon.png"/>">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Grow Agriculture</title>

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
<link href="<spring:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet" />
<link href="<spring:url value="/resources/css/material-kit.css"/>"
	rel="stylesheet" />

<script type="text/javascript">
	function changecolor() {
		var clr = document.myform.list.value;
		if (clr == undefined) {

			clr = "<spring:url value='/resources/img/home.jpg'/>";

		}
		name = "url('" + clr + "')";
		document.getElementById("back").style.backgroundImage = name;
	}
</script>



</head>

<body class="index-page" onload="changecolor();">
	<!-- Navbar -->
	<nav
		class="navbar navbar-transparent navbar-fixed-top navbar-color-on-scroll">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navigation-index">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="http://www.creative-tim.com"> </a>
			</div>

			<div class="collapse navbar-collapse" id="navigation-index">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="<spring:url value="/forgotpassword"/>"> <i
							class="material-icons">vpn_key</i> Forgot Password
					</a></li>
					<li><a href="<spring:url value="/farmerlogin"/>"> <i
							class="material-icons">perm_identity</i> Farmer Login
					</a></li>
					<li><a href="<spring:url value="/buyerlogin"/>"> <i
							class="material-icons">perm_contact_calendar</i> Buyer Login
					</a></li>
					<li><a href="<spring:url value="/"/>"> <i
							class="material-icons">airplay</i> Homepage
					</a></li>
					<li><a rel="tooltip" title="Follow us on Twitter"
						data-placement="bottom" href="https://twitter.com" target="_blank"
						class="btn btn-white btn-simple btn-just-icon"> <i
							class="fa fa-twitter"></i>
					</a></li>
					<li><a rel="tooltip" title="Like us on Facebook"
						data-placement="bottom" href="https://www.facebook.com"
						target="_blank" class="btn btn-white btn-simple btn-just-icon">
							<i class="fa fa-facebook-square"></i>
					</a></li>
					<li><a rel="tooltip" title="Follow us on Instagram"
						data-placement="bottom" href="https://www.instagram.com"
						target="_blank" class="btn btn-white btn-simple btn-just-icon">
							<i class="fa fa-instagram"></i>
					</a></li>

				</ul>
			</div>
		</div>
	</nav>
	<!-- End Navbar -->

	<div class="wrapper">


		<div id="back" class="header header-filter">

			<div class="container" align="center">

				<div class="row">
					<div class="col-md-8 col-md-offset-2 ">
						<div class="brand">
							<h1>Register</h1>
							<h3>Join us</h3>
							<div class="col-md-10 col-md-offset-4">
								<form action="" method="post" name="myform">
									<div class="col-sm-5">
										<!-- <div class="form-group label-floating">
										<label class="control-label" style="margin-left: -28px;">Email</label>
										<input type="email" name="email" class="form-control" style="color:white;">
									</div>
									<div class="form-group label-floating">
										<label class="control-label" style="margin-left: -45px;">Confirm Email</label>
										<input type="email" name="cemail" class="form-control" style="color:white;">
									</div> -->
										<div class="form-group label-floating">
											<label class="control-label" style="margin-left: -28px;">Name</label>
											<input type="text" name="name" class="form-control"
												style="color: white;">
										</div>
										<div class="form-group label-floating">
											<label class="control-label" style="margin-left: -28px;">Password</label>
											<input type="password" name="password" class="form-control"
												style="color: white;">
										</div>

										<select id="selector" class="btn btn-simple dropdown-toggle"
											data-toggle="dropdown" name="list" onclick="changecolor()"
											style="color: #000000;">
											<option value="<spring:url value="/resources/img/home.jpg"/>"
												name="farmer" selected="selected">Farmer</option>
											<option
												value="<spring:url value="/resources/img/buyers.jpg"/>"
												name="buyer">Buyer</option>
										</select>


										<button class="btn btn-white">Register</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	</div>

	</div>

	</div>



</body>
<!--   Core JS Files   -->
<script src="<spring:url value="/resources/js/jquery.min.js"/>"
	type="text/javascript"></script>
<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"
	type="text/javascript"></script>
<script src="<spring:url value="/resources/js/material.min.js"/>"></script>

<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="<spring:url value="/resources/js/nouislider.min.js"/>"
	type="text/javascript"></script>

<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
<script
	src="<spring:url value="/resources/js/bootstrap-datepicker.js"/>"
	type="text/javascript"></script>

<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
<script src="<spring:url value="/resources/js/material-kit.js"/>"
	type="text/javascript"></script>

<script type="text/javascript">
	$().ready(function() {
		// the body of this function is in material-kit.js
		materialKit.initSliders();
		window_width = $(window).width();

		if (window_width >= 992) {
			big_image = $('.wrapper > .header');

			$(window).on('scroll', materialKitDemo.checkScrollForParallax);
		}

	});
</script>
</html>
