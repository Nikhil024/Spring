<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload</title>
</head>
<body>
<jsp:include page="${upload_include_page}.jsp"/>

<form:form method="post" action="savefile" enctype="multipart/form-data">
				<div id="upload" class="swal2-container swal2-fade swal2-shown"
					style="overflow-y: auto;">
					<div role="dialog" aria-labelledby="modalTitleId"
						aria-describedby="modalContentId" class="swal2-modal swal2-show"
						tabindex="-1"
						style="width: 500px; padding: 0px; background: rgb(255, 255, 255); display: block; min-height: 315px;">
						<ul class="swal2-progresssteps" style="display: none;"></ul>
						<div class="swal2-icon swal2-error" style="display: none;">
							<span class="x-mark"><span class="line left"></span><span
								class="line right"></span></span>
						</div>
						<div class="swal2-icon swal2-question" style="display: none;">?</div>
						<div class="swal2-icon swal2-warning" style="display: none;">!</div>
						<div class="swal2-icon swal2-info" style="display: none;">i</div>
						<div class="swal2-icon swal2-success" style="display: none;">
							<span class="line tip"></span> <span class="line long"></span>
							<div class="placeholder"></div>
							<div class="fix"></div>
						</div>
						<img class="swal2-image" style="display: none;">
						<h2 class="swal2-title" id="modalTitleId">
							<p class="sweet-content">
								<label for="image"></label>
							</p>
							<h2>Choose Image</h2>
							<p></p>
							<p style="margin: 52px 133px 63px 142px;">
								<input name="file" id="fileToUpload" type="file">
							</p>
							<p style="margin-right: 274px;margin-bottom: 55px;margin-top: 70px;">
								<button type="input" class="btn btn-wd btn-success"
									value="Upload">
									<span class="btn-label"><i class="fa fa-check"></i></span>
									Upload
								</button>
							</p>
							
							<a href ="<spring:url value="/profile"/>">
							<p style="margin-right: -254px;margin-bottom: 55px;margin-top: -92px;">
								<button type="button" class="btn btn-wd btn-danger">
									<span class="btn-label"><i class="fa fa-times"></i></span>
									Cancel
								</button>
							</p>
							</a>
						</h2>
						<div id="modalContentId" class="swal2-content"
							style="display: none;"></div>
						<input class="swal2-input" style="display: none;"><input
							type="file" class="swal2-file" style="display: none;">
						<div class="swal2-range" style="display: none;">
							<output></output>
							<input type="range">
						</div>
						<select class="swal2-select" style="display: none;"></select>
						<div class="swal2-radio" style="display: none;"></div>
						<label for="swal2-checkbox" class="swal2-checkbox"
							style="display: none;"><input type="checkbox"></label>
						<textarea class="swal2-textarea" style="display: none;"></textarea>
						<div class="swal2-validationerror" style="display: none;"></div>
						<button type="button" role="button" tabindex="0"
							class="swal2-cancel swal2-styled"
							style="display: none; background-color: rgb(170, 170, 170);">Cancel</button>
						<span class="swal2-close" style="display: none;">×</span>
					</div>
				</div>


			</form:form>		



</body>
</html>