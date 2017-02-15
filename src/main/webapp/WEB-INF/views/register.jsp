<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Regsiter</title>

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
			</div>
			<div class="collapse navbar-collapse">

				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.html"> Looking to login? </a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="wrapper wrapper-full-page">
		<div class="full-page register-page" data-color="orange"
			data-image="<spring:url value="/resources/img/${bgimagename}"/>">

			<!--   you can change the color of the filter page using: data-color="blue | azure | green | orange | red | purple" -->
			<div class="content">
				<div class="container">
					<div class="row">
						<div class="col-md-8 col-md-offset-2">
							<div class="header-text">
								<h2>${projectname}</h2>
								<h4>${projectdescription}</h4>
								<hr />
							</div>
						</div>
						<div class="col-md-4 col-md-offset-2">
							<div class="media">
								<div class="media-left">
									<div class="icon">
										<i class="pe-7s-user"></i>
									</div>
								</div>
								<div class="media-body">
									<h4>${sidebar1}</h4>
									${sidebar1content}
								</div>
							</div>

							<div class="media">
								<div class="media-left">
									<div class="icon">
										<i class="pe-7s-graph1"></i>
									</div>
								</div>
								<div class="media-body">
									<h4>${sidebar2}</h4>
									${sidebar2content}

								</div>
							</div>

							<div class="media">
								<div class="media-left">
									<div class="icon">
										<i class="pe-7s-study"></i>
									</div>
								</div>
								<div class="media-body">
									<h4>${sidebar3}</h4>
									${sidebar3content}
								</div>
							</div>




						</div>
						<div class="col-md-4 col-md-offset-s1">
							<form method="post" action="<spring:url value="/register.html"/>"
								id="frm" autocomplete="off">
								<div class="card card-plain">
									<div class="content">
										<div class="form-group">
											<input type="text" placeholder="Your Name" value="${name}"
												name="name" class="form-control">
										</div>
										<div class="form-group">
											<input type="text" name="company"
												placeholder="${companyname}" disabled class="form-control">
										</div>
										<div class="form-group">
											<input type="email" name="email" value="${email}"
												placeholder="Enter email" class="form-control">
										</div>
										<div class="form-group">
											<input type="password" name="pass" placeholder="Password"
												class="form-control">
										</div>
										<div class="form-group">
											<input type="password" name="cpass"
												placeholder="Password Confirmation" class="form-control">
										</div>
									</div>
									<div class="footer text-center">
										<button type="submit" class="btn btn-fill btn-neutral btn-wd">Create
											Account</button>
									</div>
								</div>
							</form>


							<c:if test="${fail == 'show'}">
								<div class="alert alert-danger">
									<span><b> Error - </b> ${errormessage}</span>
								</div>
							</c:if>

							<c:if test="${success == 'show'}">
								<div class="alert alert-success">
									<span><b> Success - </b> ${message}</span>
								</div>
							</c:if>
						</div>






					</div>
				</div>
			</div>
		</div>

	</div>




</body>
</html>