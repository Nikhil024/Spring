<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>404 Page Error</title>
		<meta name="keywords" content="design" />
		<link href="<spring:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css"  media="all" />
	</head>
	<body>
		<div class="wrap">
				<div class="header">
					<div class="logo">
						<h1 style="color:red;">Ohhh..!! Sorry the Page you requested does not exist.</h1>
						
					</div>
				</div>
			<div class="content">
				<img src="<spring:url value="/resources/img/error-img.png"/>" title="error" />
				<!-- <p><span><label>O</label>hh.....</span>You Requested the page that is no longer There.</p> -->
				<p></p>
				<a href="<spring:url value="/"/>">Back To Home</a>
				<!-- <div class="copy-right">
					<p>&#169 All rights Reserved</p>
				</div> -->
   			</div>
		</div>
	</body>
</html>

