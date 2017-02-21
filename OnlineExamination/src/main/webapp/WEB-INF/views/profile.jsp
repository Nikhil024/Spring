<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
<title>Profile</title>
<jsp:include page="Header.jsp"></jsp:include>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.css"
	rel="stylesheet" />

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.min.css"
	rel="stylesheet" />



<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.common.js">
	
</script>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.common.min.js">
	
</script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.js">
	
</script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.min.css">
	
</script>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.4.2/sweetalert2.min.js">
	
</script>
</head>
<body>

	<div class="wrapper">
		<div class="sidebar" data-color="orange"
			data-image="<spring:url value="/resources/img/${bgimagename}"/>">
			<!--

            Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
            Tip 2: you can also add an image using data-image tag

        -->


			<div class="sidebar-wrapper">

				<div class="user">
					<a href="<spring:url value="/upload"/>">
						<div class="photo animated lightSpeedIn">

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
							class="collapsed animated lightSpeedIn"> ${username} <b
							class="caret"></b>
						</a>
						<div class="collapse" id="collapseExample">
							<ul class="nav">
								<li><a href="#">My Profile</a></li>
								<li><a href="#">Edit Profile</a></li>
								<li><a href="#">Settings</a></li>
							</ul>
						</div>
					</div>
				</div>

				<ul class="nav">
					<li><a href="../dashboard.html"> <i class="pe-7s-graph"></i>
							<p>Dashboard</p>
					</a></li>
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
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<jsp:include page="navBar.jsp"></jsp:include>
			
			
			











































			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-4">
							<div class="card card-user">
								<div class="image">
									<img
										src="<spring:url value="/resources/img/full-screen-image-3.jpg"/>"
										alt="..." />
								</div>
								<div class="content">
									<div class="author">
										<a href="#"> <c:if test="${nopicture == 'YES'}">
												<img class="avatar border-gray"
													src="<spring:url value="/resources/img/${userprofileimage}"/>" />
											</c:if> <c:if test="${picture == 'YES'}">
												<img class="avatar border-gray"
													src="<spring:url value="/images/profile/${userprofileimage}"/>" />
											</c:if>


											<h4 class="title">${username}<br /> <small>michael24</small>
											</h4>
										</a>
									</div>
									<p class="description text-center">
										"Lamborghini Mercy <br> Your chick she so thirsty <br>
										I'm in that two seat Lambo"
									</p>
								</div>
								<hr>
								<div class="text-center">
									<button href="#" class="btn btn-simple">
										<i class="fa fa-facebook-square"></i>
									</button>
									<button href="#" class="btn btn-simple">
										<i class="fa fa-twitter"></i>
									</button>
									<button href="#" class="btn btn-simple">
										<i class="fa fa-google-plus-square"></i>
									</button>

								</div>
							</div>
						</div>
						<div class="col-md-8">
							<div class="card">
								<div class="header">
									<h4 class="title">Profile Details</h4>
								</div>
								<div class="content">
									<form action="<spring:url value="/profile"/>" method="post" autocomplete="off">
										<div class="row">
											<div class="col-md-5">
												<div class="form-group">
													<label>Company</label> <input type="text"
														class="form-control" disabled placeholder="Company"
														value="${company}">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label for="exampleInputEmail1">Email address</label> <input
														type="email" name="email" class="form-control" disabled placeholder="Email" value="${email}">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label>First Name</label> <input type="text"
														class="form-control" name="fname" placeholder="First Name" value="${fname}">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Last Name</label> <input type="text"
														class="form-control" name="lname" placeholder="Last Name"
														value="${lname}">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Address</label> <input type="text"
														class="form-control" placeholder="Home Address"
														name="address" value="${address}">
												</div>
											</div>
										</div>
<p>asdas: ${userDetails}</p>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>City</label> <input type="text" class="form-control"
														name="city" placeholder="City" value="${city}">
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Country</label> <input type="text"
														name="country" class="form-control" placeholder="Country" value="${country}">
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Postal Code</label> <input type="number"
														name="postalcode" class="form-control" placeholder="Postal Code" value="${postalcode}">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>About Me</label>
													<textarea rows="5" class="form-control"
														name="aboutme" placeholder="Enter your description">${aboutme}</textarea>
												</div>
											</div>
										</div>

										<button type="submit" class="btn btn-info btn-fill pull-right">Update
											Profile</button>
										<div class="clearfix"></div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
