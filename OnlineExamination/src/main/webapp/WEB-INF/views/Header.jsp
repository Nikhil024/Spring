<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src="https://use.fontawesome.com/24927df7c3.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="<spring:url value="/resources/css/font-awesome.min.css"/>">

<link rel="stylesheet"
	href="<spring:url value="/resources/css/buttons.css"/>">


<link rel="stylesheet"
	href="<spring:url value="/resources/css/mdl/material.min.css"/>">
<script src="<spring:url value="/resources/css/mdl/material.min.js"/>"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

<link href="<spring:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet" />

<!--  Light Bootstrap Dashboard core CSS    -->
<link
	href="<spring:url value="/resources/css/light-bootstrap-dashboard.css"/>"
	rel="stylesheet" />

<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="<spring:url value="/resources/css/demo.css"/>"
	rel="stylesheet" />

<link href="<spring:url value="/resources/css/animate.css"/>"
	rel="stylesheet" />



<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link href="<spring:url value="/resources/css/pe-icon-7-stroke.css"/>"
	rel="stylesheet" />
<link
	href="<spring:url value="/resources/css/sweetalert2.min.css"/>"
	rel="stylesheet" />	
	
	
<script>
	history.pushState(null, null, document.URL);
	window.addEventListener('popstate', function() {
		history.pushState(null, null, document.URL);
	});
</script>



</head>
<body> <!-- oncontextmenu="return false;"> -->
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.8";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>


	<!--   Core JS Files and PerfectScrollbar library inside jquery.ui   -->
	<script src="<spring:url value="/resources/js/jquery.min.js"/>"
		type="text/javascript"></script>
	<script src="<spring:url value="/resources/js/jquery-ui.min.js"/>"
		type="text/javascript"></script>
	<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"
		type="text/javascript"></script>

<script
		src="<spring:url value="/resources/js/sweetalert2.min.js"/>">
		</script>
	<!--  Forms Validations Plugin -->
	<script src="<spring:url value="/resources/js/jquery.validate.min.js"/>"></script>

	<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
	<script src="<spring:url value="/resources/js/moment.min.js"/>"></script>

	<!--  Date Time Picker Plugin is included in this js file -->
	<script
		src="<spring:url value="/resources/js/bootstrap-datetimepicker.js"/>"></script>

	<!--  Select Picker Plugin -->
	<script
		src="<spring:url value="/resources/js/bootstrap-selectpicker.js"/>"></script>

	<!--  Checkbox, Radio, Switch and Tags Input Plugins -->
	<script
		src="<spring:url value="/resources/js/bootstrap-checkbox-radio-switch-tags.js"/>"></script>

	<!--  Charts Plugin -->
	<script src="<spring:url value="/resources/js/chartist.min.js"/>"></script>

	<!--  Notifications Plugin    -->
	<script src="<spring:url value="/resources/js/bootstrap-notify.js"/>"></script>

	<!-- Sweet Alert 2 plugin -->
	<script src="<spring:url value="/resources/js/sweetalert2.js"/>"></script>

	<!-- Vector Map plugin -->
	<script src="<spring:url value="/resources/js/jquery-jvectormap.js"/>"></script>

	<!--  Google Maps Plugin    -->
	<script src="https://maps.googleapis.com/maps/api/js"></script>

	<!-- Wizard Plugin    -->
	<script
		src="<spring:url value="/resources/js/jquery.bootstrap.wizard.min.js"/>"></script>

	<!--  Datatable Plugin    -->
	<script src="<spring:url value="/resources/js/bootstrap-table.js"/>"></script>

	<!--  Full Calendar Plugin    -->
	<script src="<spring:url value="/resources/js/fullcalendar.min.js"/>"></script>

	<!-- Light Bootstrap Dashboard Core javascript and methods -->
	<script
		src="<spring:url value="/resources/js/light-bootstrap-dashboard.js"/>"></script>

	<!--   Sharrre Library    -->
	<script src="<spring:url value="/resources/js/jquery.sharrre.js"/>"></script>

	<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
	<script src="<spring:url value="/resources/js/demo.js"/>"></script>

	<script type="text/javascript">
		$().ready(function() {
			lbd.checkFullPageBackgroundImage();

			setTimeout(function() {
				// after 1000 ms we add the class animated to the login/register card
				$('.card').removeClass('card-hidden');
			}, 700)
		});
	</script>

	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');

		ga('create', 'UA-46172202-1', 'auto');
		ga('send', 'pageview');
	</script>

</body>
</html>