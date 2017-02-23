<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Login</title>
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
				<a class="navbar-brand" href="<spring:url value="/"/>">${projectname}</a>
			</div>
			<div class="collapse navbar-collapse">
				<c:if test="${registerComponentView == 'show'}">
				<ul class="nav navbar-nav navbar-right animated bounceInDown">
					<li><a href="<spring:url value="/register.html"/>">
							Register </a></li>
				</ul>
				</c:if>
				<c:if test="${success == 'show'}">
				<ul class="nav navbar-nav navbar-right animated hinge">
					<li><a href="<spring:url value="/register.html"/>">
							Register </a></li>
				</ul>
				</c:if>
				
			</div>
		</div>
	</nav>


	<div class="wrapper wrapper-full-page">
		<div class="full-page login-page" data-color=""
			data-image="<spring:url value="/resources/img/${bgimagename}"/>">

			<!--   you can change the color of the filter page using: data-color="blue | azure | green | orange | red | purple" -->
			<div class="content">
				<div class="container">
					<div class="row">
						<div class="col-md-4 col-sm-6 col-md-offset-4 col-sm-offset-3">
							<form method="post" id="loginform"
								action="<spring:url value="/login"/>" autocomplete="off">

								<!--   if you want to have the card without animation please remove the ".card-hidden" class   -->
								<div class="card card-hidden">
									<div class="header text-center">Login</div>
									<div class="content">
										<div class="form-group">
											<label>Email address</label> <input type="email" id="email"
												name="email" placeholder="Enter email"
												value="${email_value}" class="form-control">
										</div>
										<div class="form-group">
											<label>Password</label> <input type="password"
												name="password" placeholder="Password" class="form-control">
										</div>


										<div class="form-group">
											<label class="checkbox"> <input type="checkbox"
												name="subscribe" data-toggle="checkbox" value="YES">
												Subscribe to newsletter
											</label>
										</div>


									</div>
									<div class="footer text-center">
										<button type="submit" class="btn btn-fill btn-warning btn-wd">Login</button>
									</div>
								</div>

							</form>
							<c:if test="${fail == 'show'}">
								<div class="alert alert-danger">
									<span><b> Error - </b> ${data}</span>
								</div>
							</c:if>

							<c:if test="${success == 'show'}">
								<div class="alert alert-success">
									<span><b> Success - </b> ${data}</span>
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<c:if test="${redirect == 'true'}">
		<script>
  setTimeout(function() {
      document.location = "<spring:url value="/${redirectValue}"/>";
  }, 4000); // 
</script>
	</c:if>


</body>
</html>