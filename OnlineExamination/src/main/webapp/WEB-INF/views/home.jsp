<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Online Examination</title>

<jsp:include page="Header.jsp"></jsp:include>
</head>
<body>

	<nav class="navbar navbar-transparent navbar-absolute">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navigation-example-2">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">${projectname}</a>
			</div>
			<div class="collapse navbar-collapse">

				<ul class="nav navbar-nav navbar-right">

				</ul>
			</div>
		</div>
	</nav>

	<div class="wrapper wrapper-full-page">

		<div class="full-page lock-page" data-color=""
			data-image="<spring:url value="/resources/img/${bgimagename}"/>">

			<!--   you can change the color of the filter page using: data-color="blue | azure | green | orange | red | purple" -->
			<div class="content">
				<!-- Primary-colored flat button -->
				<!-- Accent-colored flat button -->

				<center>
					<a href=""
						class="button button-3d button-glow button-action button-pill button-large"><span
						class="btn-label btn-label-right"> <i class="pe-7s-users"></i>
					</span>Admin Login</a> <br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br /> <a href="<spring:url value="/login"/>"
						class="button button-3d button-glow button-action button-pill button-large"><span
						class="btn-label btn-label-right"> <i
							class="pe-7s-add-user"></i>
					</span>Student Login</a>
				</center>

			</div>

		</div>

	</div>
</body>


</html>