<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>eShop app</title>

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
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<link href="resources/css/material-kit.css" rel="stylesheet" />
<link href="resources/css/demo.css" rel="stylesheet" />
<style>
div {
	padding: 5px;
}
</style>
<style>
pre.prettyprint {
	background-color: #eee;
	border: 0px;
	margin-bottom: 60px;
	margin-top: 30px;
	padding: 20px;
	text-align: left;
}

.atv, .str {
	color: #05AE0E;
}

.tag, .pln, .kwd {
	color: #3472F7;
}

.atn {
	color: #2C93FF;
}

.pln {
	color: #333;
}

.com {
	color: #999;
}

.space-top {
	margin-top: 50px;
}

.btn-primary .caret {
	border-top-color: #3472F7;
	color: #3472F7;
}

.area-line {
	border: 1px solid #999;
	border-left: 0;
	border-right: 0;
	color: #666;
	display: block;
	margin-top: 20px;
	padding: 8px 0;
	text-align: center;
}

.area-line a {
	color: #666;
}

.container-fluid {
	padding-right: 15px;
	padding-left: 15px;
}

.table-shopping .td-name {
	min-width: 130px;
}

body {
	background-color: white;
}
</style>
<script>
	function validateForm() {
		var a = document.forms["Form"]["input_count"].value;
		if (a == null) {
			alert("Please Fill All Required Field");
			return false;
		}
	}
</script>

</head>
<body>

	<form method="post" name="Form" action="<spring:url value="/"/>">

		<div class="col-sm-4">
			<div class="form-group">
				<input id="count_inp" type="text" name="input_count"
					placeholder="Count " class="form-control" />
			</div>
		</div>
		<button class="btn btn-default" type="submit" value="Submit"
			onclick="return validateForm()">Submit</button>
		<p>
			<br />
		</p>
	</form>
	<h1>${count}</h1>

	<%
		try {
			int count = 0;
			if (session.getAttribute("count").toString() != null) {
				count = Integer.parseInt(session.getAttribute("count").toString());
			}
			for (int i = 0; i < count; i++) {
				
				
	%>
	<form method="post" name="form" action="<spring:url value="/json"/>">
		<div class="col-sm-5">
			<div class="form-group">
				<input type="text" name="device_name<%=i%>" placeholder="Device"
					class="form-control" />
			</div>
		</div>


		<div class="col-sm-5">
			<div class="form-group">
				<input type="text" name="Status<%=i%>" placeholder="Status"
					class="form-control" />
			</div>
		</div>
		</div>



		<%
			}
				if (count <= 0) {
		%>
		<h1>Please enter the minimum count as 1</h1>
		<%
			} else {
		%>
		<button class="btn btn-default" type="submit" value="Submit">Submit</button>
		<%
			}
		%>
		<%
			} catch (Exception e) {
			}
		%>
	</form>
</body>


<!--   Core JS Files   -->
<script src="resources/js/jquery.min.js" type="text/javascript"></script>
<script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="resources/js/material.min.js"></script>

<!--  Plugin for the Sliders, full documentation here: http://refreshless.com/nouislider/ -->
<script src="resources/js/nouislider.min.js" type="text/javascript"></script>

<!--  Plugin for the Datepicker, full documentation here: http://www.eyecon.ro/bootstrap-datepicker/ -->
<script src="resources/js/bootstrap-datepicker.js"
	type="text/javascript"></script>

<!-- Control Center for Material Kit: activating the ripples, parallax effects, scripts from the example pages etc -->
<script src="resources/js/material-kit.js" type="text/javascript"></script>

<script>
	var header_height;
	var fixed_section;
	var floating = false;

	$().ready(function() {
		suggestions_distance = $("#suggestions").offset();
		pay_height = $('.fixed-section').outerHeight();

		$(window).on('scroll', materialKit.checkScrollForTransparentNavbar);

		// the body of this function is in resources/material-kit.js
		materialKit.initSliders();
	});
</script>







</html>