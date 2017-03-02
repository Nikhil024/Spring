<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
<head>
<title>Profile</title>
<jsp:include page="Header.jsp" />

<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
	<script src="<spring:url value="/resources/js/moment.min.js"/>"></script>

	<!--  Date Time Picker Plugin is included in this js file -->
	<script
		src="<spring:url value="/resources/js/bootstrap-datetimepicker.js"/>"></script>
<link href="<spring:url value="/resources/css/sweetalert2.css"/>"
	rel="stylesheet" />

<link href="<spring:url value="/resources/css/sweetalert2.min.css"/>"
	rel="stylesheet" />

<script src="<spring:url value="/resources/js/sweetalert2.common.js"/>">
	
</script>

<script
	src="<spring:url value="/resources/js/sweetalert2.common.min.js"/>">
	
</script>

<script src="<spring:url value="/resources/js/sweetalert2.js"/>">
	
</script>

<script src="<spring:url value="/resources/js/sweetalert2.min.js"/>">
	
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

			<jsp:include page="sidebar.jsp"></jsp:include>
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
										<a href="<spring:url value="/upload"/>"> <c:if
												test="${nopicture == 'YES'}">
												<img class="avatar border-gray"
													src="<spring:url value="/resources/img/${userprofileimage}"/>" />
											</c:if> <c:if test="${picture == 'YES'}">
												<img class="avatar border-gray"
													src="<spring:url value="/images/profile/${userprofileimage}"/>" />
											</c:if>


											<h4 class="title">${username}<br /> <small>${email}</small></h4>
											
										</a>
									</div>
									<p class="description text-center">${aboutme}</p>
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
									<form action="<spring:url value="/profile"/>" method="post"
										autocomplete="off">
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
														type="email" name="email" class="form-control" disabled
														placeholder="Email" value="${email}">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>First Name</label> <input type="text"
														class="form-control" name="fname" placeholder="First Name"
														value="${fname}">
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Last Name</label> <input type="text"
														class="form-control" name="lname" placeholder="Last Name"
														value="${lname}">
												</div>
											</div>
											
											<div class="col-md-4">
													<div class="form-group">
													<label>Date Of Birth</label> 
														<input type="text" class="form-control datepicker"
															placeholder="Date Picker Here" />
													</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-11">
												<div class="form-group">
													<label>Address</label> <input type="text"
														class="form-control" placeholder="Home Address"
														name="address" value="${address}">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<label>City</label> <input type="text" class="form-control"
														name="city" placeholder="City" value="${city}">
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Country</label> <input type="text" name="country"
														class="form-control" placeholder="Country"
														value="${country}">
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Postal Code</label> <input type="number"
														name="postalcode" class="form-control"
														placeholder="Postal Code" value="${postalcode}">
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>About Me</label>
													<textarea rows="5" class="form-control" name="aboutme"
														placeholder="Enter your description">${aboutme}</textarea>
												</div>
											</div>
										</div>

										<button type="submit" class="btn btn-info btn-fill pull-right">Update
											Profile</button>
										<br />
										<div class="fb-like"
											data-href="https://developers.facebook.com/docs/plugins/"
											data-layout="standard" data-action="like" data-size="small"
											data-show-faces="true" data-share="true"></div>
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
