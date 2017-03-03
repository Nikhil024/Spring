<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>


			<div class="sidebar-wrapper">
	<div class="logo">
				<a href="<spring:url value="/"/>" class="logo-text">${projectname}</a>
			</div>
				<div class="user">
					<a href="<spring:url value="/upload"/>">
						<div class="photo animated tada">

							<c:if test="${nopicture == 'YES'}">
								<img
									src="<spring:url value="/resources/img/${userprofileimage}"/>" />
							</c:if>

							<c:if test="${picture == 'YES'}">
								<img
									src="<spring:url value="/images/profile/${userprofileimage}"/>" width="100%" height="100%" />
							</c:if>



						</div>
					</a>
					<div class="info">
						<a data-toggle="collapse" href="#collapseExample"
							class="collapsed animated tada"> ${username} <b
							class="caret"></b>
						</a>
						 <div class="collapse" id="collapseExample">
							<ul class="nav">
								<li><a href="<spring:url value="/profile"/>">My Profile</a></li>
								<li><a href="<spring:url value="/dashboard"/>">Dashboard</a></li>
								<li><a href="<spring:url value="/"/>">Settings</a></li>
							</ul>
						</div>
					</div>
				</div>

				<ul class="nav">
					<li><a href="<spring:url value="/dashboard"/>"> <i class="pe-7s-display1"></i>
							<p>Dashboard</p>
					</a></li>
					<li><a href=""><i class="pe-7s-news-paper"></i>
					<p>Mock Questions</p>
					</a></li>
					<li><a href="<spring:url value="/exam"/>"><i class="pe-7s-study"></i>
					<p>Take Exam</p>
					
					</a>
					</li>
					<!-- 
					<li><a data-toggle="collapse" href="#componentsExamples">
							<i class="pe-7s-plugin"></i>
							<p>
								Components <b class="caret"></b>
							</p>
					</a>
						<div class="collapse" id="componentsExamples">
							<ul class="nav">
								<li><a href="../components/buttons.html">Buttons</a></li>
								<li><a href="../components/grid.html">Grid System</a></li>
								<li><a href="../components/icons.html">Icons</a></li>
								<li><a href="../components/notifications.html">Notifications</a></li>
								<li><a href="../components/panels.html">Panels</a></li>
								<li><a href="../components/sweet-alert.html">Sweet
										Alert</a></li>
								<li><a href="../components/typography.html">Typography</a></li>
							</ul>
						</div></li>

					<li><a data-toggle="collapse" href="#formsExamples"> <i
							class="pe-7s-note2"></i>
							<p>
								Forms <b class="caret"></b>
							</p>
					</a>
						<div class="collapse" id="formsExamples">
							<ul class="nav">
								<li><a href="../forms/regular.html">Regular Forms</a></li>
								<li><a href="../forms/extended.html">Extended Forms</a></li>
								<li><a href="../forms/validation.html">Validation Forms</a></li>
								<li><a href="../forms/wizard.html">Wizard</a></li>
							</ul>
						</div></li>

					<li><a data-toggle="collapse" href="#tablesExamples"> <i
							class="pe-7s-news-paper"></i>
							<p>
								Tables <b class="caret"></b>
							</p>
					</a>
						<div class="collapse" id="tablesExamples">
							<ul class="nav">
								<li><a href="../tables/regular.html">Regular Tables</a></li>
								<li><a href="../tables/extended.html">Extended Tables</a></li>
								<li><a href="../tables/bootstrap-table.html">Bootstrap
										Table</a></li>
								<li><a href="../tables/datatables.net.html">DataTables.net</a></li>
							</ul>
						</div></li>

					<li><a data-toggle="collapse" href="#mapsExamples"> <i
							class="pe-7s-map-marker"></i>
							<p>
								Maps <b class="caret"></b>
							</p>
					</a>
						<div class="collapse" id="mapsExamples">
							<ul class="nav">
								<li><a href="../maps/google.html">Google Maps</a></li>
								<li><a href="../maps/vector.html">Vector Maps</a></li>
								<li><a href="../maps/fullscreen.html">Full Screen Map</a></li>
							</ul>
						</div></li>

					<li><a href="../charts.html"> <i class="pe-7s-graph1"></i>
							<p>Charts</p>
					</a></li>

					<li><a href="../calendar.html"> <i class="pe-7s-date"></i>
							<p>Calendar</p>
					</a></li>

					<li class="active"><a data-toggle="collapse"
						href="#pagesExamples" area-expanded="true"> <i
							class="pe-7s-gift"></i>
							<p>
								Pages <b class="caret"></b>
							</p>
					</a>
						<div class="collapse in" id="pagesExamples">
							<ul class="nav">
								<li><a href="login.html">Login Page</a></li>
								<li><a href="register.html">Register Page</a></li>
								<li><a href="lock.html">Lock Screen Page</a></li>
								<li class="active"><a href="user.html">User Page</a></li>
								<li><a href="#">More coming soon...</a></li>
							</ul>
						</div></li>
				</ul> -->
			</div> 

</body>
</html>