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
			<div class="content">
				<div class="container-fluid">
					<div class="card">
						<div class="row">
							<div class="col-md-4">

								<div class="header">
									<h4 class="title">Select Subject</h4>
									<p class="category">Select Multiple Subjects also</p>
								</div>
								<div class="content">
									<select multiple data-title="Select Subjects" name="currency"
										class="selectpicker" data-style="btn-info btn-fill btn-block"
										data-menu-style="dropdown-blue">
										<c:forEach var="sub" items="${subjects}">
											<option value="${sub.id}">${sub.name}</option>
										</c:forEach>
									</select>

								</div>

							</div>
						</div>
						
					</div>
					<div class="card">
					<div class="row">
					<div class="col-md-4">

								<div class="header">
									<h4 class="title">Select Subject</h4>
									<p class="category">Select Multiple Subjects also</p>
								</div>
								<div class="content">
									<select multiple data-title="Select Subjects" name="currency"
										class="selectpicker" data-style="btn-info btn-fill btn-block"
										data-menu-style="dropdown-blue">
										<c:forEach var="sub" items="${subjects}">
											<option value="${sub.id}">${sub.name}</option>
										</c:forEach>
									</select>

								</div>

							</div>
							</div>
							</div>
				</div>
			</div>

			<form method="post" id="loginform"
				action="<spring:url value="/login"/>" autocomplete="off">
				<div class="form-group">
					<label class="checkbox"> <input type="checkbox"
						name="subscribe" data-toggle="checkbox" value="YES"> Terms
						& Conditions
					</label>
				</div>
			</form>

		</div>
	</div>

</body>
</html>