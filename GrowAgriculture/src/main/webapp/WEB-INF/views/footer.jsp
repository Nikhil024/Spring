<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="<spring:url value="/resources/img/dashboard/apple-icon.png"/>">
	<link rel="icon" type="image/png" sizes="96x96" href="<spring:url value="/resources/img/dashboard/favicon.png"/>">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Grow Agriculture Dashboard</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="<spring:url value="/resources/css/dashboard/bootstrap.min.css"/>" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="<spring:url value="/resources/css/dashboard/animate.min.css"/>" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="<spring:url value="/resources/css/dashboard/paper-dashboard.css"/>" rel="stylesheet"/>


    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="<spring:url value="/resources/css/dashboard/themify-icons.css"/>" rel="stylesheet">

</head>
<body>
<footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>

                        <li>
                            <a href="<spring:url value="/"/>">
                                Grow Agriculture
                            </a>
                        </li>
                        <li>
                            <a href="">
                               Blog
                            </a>
                        </li>
                        <li>
                            <a href="">
                                Licenses
                            </a>
                        </li>
                    </ul>
                </nav>
                <div class="copyright pull-right">
                    &copy; <script>document.write(new Date().getFullYear())</script>, made with <i class="fa fa-heart heart"></i> for our <a href="">Indian Farmers.</a>
                </div>
            </div>
        </footer>
</body>

    <!--   Core JS Files   -->
    <script src="<spring:url value="/resources/js/dashboard/jquery-1.10.2.js"/>" type="text/javascript"></script>
	<script src="<spring:url value="/resources/js/dashboard/bootstrap.min.js"/>" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="<spring:url value="/resources/js/dashboard/bootstrap-checkbox-radio.js"/>"></script>

	<!--  Charts Plugin -->
	<script src="<spring:url value="/resources/js/dashboard/chartist.min.js"/>"></script>

    <!--  Notifications Plugin    -->
    <script src="<spring:url value="/resources/js/dashboard/bootstrap-notify.js"/>"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="<spring:url value="/resources/js/dashboard/paper-dashboard.js"/>"></script>
</html>