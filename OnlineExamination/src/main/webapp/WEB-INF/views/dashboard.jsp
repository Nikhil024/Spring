<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="Header.jsp" />
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
				<jsp:include page="sidebar.jsp"></jsp:include>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="navbar-minimize">
						<button id="minimizeSidebar"
							class="btn btn-warning btn-fill btn-round btn-icon">
							<i class="fa fa-ellipsis-v visible-on-sidebar-regular"></i> <i
								class="fa fa-navicon visible-on-sidebar-mini"></i>
						</button>
					</div>
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="#">Dashboard PRO</a>
					</div>
					<div class="collapse navbar-collapse">

						<form class="navbar-form navbar-left navbar-search-form"
							role="search">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-search"></i></span>
								<input type="text" value="" class="form-control"
									placeholder="Search...">
							</div>
						</form>

						<ul class="nav navbar-nav navbar-right">
							<li><a href="charts.html"> <i class="fa fa-line-chart"></i>
									<p>Stats</p>
							</a></li>

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-gavel"></i>
									<p class="hidden-md hidden-lg">
										Actions <b class="caret"></b>
									</p>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">Create New Post</a></li>
									<li><a href="#">Manage Something</a></li>
									<li><a href="#">Do Nothing</a></li>
									<li><a href="#">Submit to live</a></li>
									<li class="divider"></li>
									<li><a href="#">Another Action</a></li>
								</ul></li>

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <span
									class="notification">5</span>
									<p class="hidden-md hidden-lg">
										Notifications <b class="caret"></b>
									</p>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">Notification 1</a></li>
									<li><a href="#">Notification 2</a></li>
									<li><a href="#">Notification 3</a></li>
									<li><a href="#">Notification 4</a></li>
									<li><a href="#">Another notification</a></li>
								</ul></li>

							<li class="dropdown dropdown-with-icons"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown"> <i
									class="fa fa-list"></i>
									<p class="hidden-md hidden-lg">
										More <b class="caret"></b>
									</p>
							</a>
								<ul class="dropdown-menu dropdown-with-icons">
									<li><a href="#"> <i class="pe-7s-mail"></i> Messages
									</a></li>
									<li><a href="#"> <i class="pe-7s-help1"></i> Help
											Center
									</a></li>
									<li><a href="#"> <i class="pe-7s-tools"></i> Settings
									</a></li>
									<li class="divider"></li>
									<li><a href="#"> <i class="pe-7s-lock"></i> Lock
											Screen
									</a></li>
									<li><a href="<spring:url value="/logout"/>"
										class="text-danger"> <i class="pe-7s-close-circle"></i>
											Log out
									</a></li>
								</ul></li>

						</ul>
					</div>
				</div>
			</nav>

			<div class="content">
				<div class="container-fluid">

					<div class="row">
						<div class="col-md-5">
							<div class="card">
								<div class="header">
									<h4 class="title">Email Statistics</h4>
									<p class="category">Last Campaign Performance</p>
								</div>
								<div class="content">
									<c:if test="${piechartpictureexists == 'YES'}">
										<img
											src="<spring:url value="/images/pieChart/${piechartname}"/>"
											width="387" height="400" />
									</c:if>
									<c:if test="${piechartpictureexists == 'NO'}">
										<h4>Please take Exams to check your statistics.</h4>
									</c:if>
								</div>
								<div class="footer">
									<div class="legend">
										<i class="fa fa-circle text-info"></i> Open <i
											class="fa fa-circle text-danger"></i> Bounce <i
											class="fa fa-circle text-warning"></i> Unsubscribe
									</div>
									<hr>
									<div class="stats">
										<i class="fa fa-clock-o"></i> Campaign sent 2 days ago
									</div>
								</div>

							</div>
						</div>

						<div class="col-lg-4 col-md-5">
							<div class="card">
								<div class="header">
									<h4 class="title">Members</h4>
								</div>
								<div class="content">
									<ul class="list-unstyled team-members">

										<li>
											<div class="row">
												<div class="col-xs-3">
													<div class="photo animated tada">

														<c:if test="${nopicture == 'YES'}">
															<img
																src="<spring:url value="/resources/img/${userprofileimage}"/>" />
														</c:if>

														<c:if test="${picture == 'YES'}">
															<img
																src="<spring:url value="/images/profile/${userprofileimage}"/>"
																width="100%" height="100%" />
														</c:if>



													</div>
												</div>
												<div class="col-xs-6">
													DJ Khaled <br>

												</div>

											</div>
										</li>


									</ul>
								</div>
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
