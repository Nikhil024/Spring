<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Upload</title>
<style>
div.show-image {
    position: relative;
    float:left;
    margin:5px;
}
div.show-image:hover img{
    opacity:0.5;
}
div.show-image:hover input {
    display: block;
}
div.show-image input {
    position:absolute;
    display:none;
}
div.show-image input.delete {
    top:0;
    left:79%;
}

</style>
</head>


<body>
<%ArrayList<String> location = (ArrayList) session.getAttribute("location");%>
	<div class="wrapper">
		<jsp:include page="header.jsp" />
		<div class="main-panel">
			<div class="content">
				<div class="container-fluid">
					<div class="card card-map">
						<div class="header">
							<h4 class="title">Your Recent Uploads</h4>
						</div>
						<div class="map">
							<div id="map">
							<div class="show-image">
							<%if(location.size()!=0){ 
							for(int i=0; i<location.size();i++){
								System.out.println("location array in uploadform.jsp: "+location.get(i));
                        %><img src="<spring:url value="/images/"/><%=location.get(i)%>" style="width:304px;height:228px;"/>
    						<input class="delete" type="button" value="Delete" />
                        <%
                        }}
							else{
								%>
								<h5>You have no Recent Uploads</h5>
								<%
							}
                        %>
						</div>
							</div>
						</div>
						
							<form:form method="post" action="savefile"
								enctype="multipart/form-data" onSubmit="return Validate();">
								<p>
									<label for="image">Choose Image</label>
								</p>
								<p>
									<input name="file" id="fileToUpload" type="file" />
								</p>
								<p>
									<input type="submit" value="Upload">
								</p>
							</form:form>

						

					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />



</body>



</html>
