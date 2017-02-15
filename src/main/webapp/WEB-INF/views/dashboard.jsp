<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html lang="en">
<head>
</head>
<body>
<%ArrayList<String> location = (ArrayList) session.getAttribute("location");%>
	<div class="wrapper">
	
		<jsp:include page="header.jsp"></jsp:include>
		 <div class="main-panel">
		 <nav class="navbar navbar-default">
            <div class="container-fluid">
		  <div class="navbar-header">
                    <a class="navbar-brand" href="#">Vegetables and Fruits</a>
                </div>
		 </div>
		 </nav>
 <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                        <div class="header">
                        <h4 class="title"></h4>
                        </div>
                        <% if(location.size()!=0){ 
                        for(int i=0; i<location.size();i++){
                        %><img src="<spring:url value="/images/"/><%=location.get(i)%>" style="width:304px;height:228px;"/>
                        <%
                        }}
                        else{
                        	%>
                        	<center><h4>No Farmers have uploaded any pictures yet!</h4></center>
                        	<%
                        }
                        %>
                        
                        <img src="<spring:url value="/images/aplive-african-watering-hole-cam.jpg"/>" style="width:304px;height:228px;"/>
                         <img src="<spring:url value="/images/2016-12-26 16_14_55-Android Virtual Device Manager.jpg"/>" style="width:304px;height:228px;"/>
                        
                        
                           <!--  <div class="header">
                                <h4 class="title">Paper Dashboard Headings</h4>
                                <p class="category">Created using <a href="https://www.google.com/fonts/specimen/Muli">Muli</a> Font Family</p>
                            </div>
                            <div class="content">

                                <div class="typo-line">
                                    <h1><p class="category">Header 1</p>Paper Dashboard Heading </h1>
                                </div>

                                    <div class="typo-line">
                                    <h2><p class="category">Header 2</p>Paper Dashboard Heading </h2>
                                </div>
                                <div class="typo-line">
                                    <h3><p class="category">Header 3</p>Paper Dashboard Heading </h3>
                                </div>
                                <div class="typo-line">
                                    <h4><p class="category">Header 4</p>Paper Dashboard Heading </h4>
                                </div>
                                <div class="typo-line">
                                    <h5><p class="category">Header 5</p>Paper Dashboard Heading </h5>
                                </div>
                                 <div class="typo-line">
                                    <h6><p class="category">Header 6</p>Paper Dashboard Heading </h6>
                                </div>
                                <div class="typo-line">
                                    <p><span class="category">Paragraph</span>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam.</p>
                                </div>
                                <div class="typo-line">
                                    <p class="category">Quote</p>
                                    <blockquote>
                                     <p>
                                     Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam.
                                     </p>
                                     <small>
                                     Steve Jobs, CEO Apple
                                     </small>
                                    </blockquote>
                                </div>

                                <div class="typo-line">
                                    <p class="category">Muted Text</p>
                                    <p class="text-muted">
                                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet.
                                    </p>
                                </div>
                                <div class="typo-line">
                                    
                                     there are also "text-info", "text-success", "text-warning", "text-danger" clases for the text
                                    
                                    <p class="category">Coloured Text</p>
                                    <p class="text-primary">
                                        Text Primary - Light Bootstrap Table Heading and complex bootstrap dashboard you've ever seen on the internet.
                                    </p>
                                    <p class="text-info">
                                        Text Info - Light Bootstrap Table Heading and complex bootstrap dashboard you've ever seen on the internet.
                                    </p>
                                    <p class="text-success">
                                        Text Success - Light Bootstrap Table Heading and complex bootstrap dashboard you've ever seen on the internet.
                                    </p>
                                    <p class="text-warning">
                                        Text Warning - Light Bootstrap Table Heading and complex bootstrap dashboard you've ever seen on the internet.
                                    </p>
                                    <p class="text-danger">
                                        Text Danger - Light Bootstrap Table Heading and complex bootstrap dashboard you've ever seen on the internet.
                                    </p>
                                </div>

                                <div class="typo-line">
                                    <h2><p class="category">Small Tag</p>Header with small subtitle <br><small>".small" is a tag for the headers</small> </h2>
                                </div>


                            </div> -->
                        </div>
                    </div>

                </div>
            </div>
        </div>
		</div>

	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>



</body>

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						$
								.notify(
										{
											icon : 'ti-gift',
											message : "Hi ${name} Welcome to <b>Grow Agriculture</b> a site dedicated for the Indian Farmers."

										}, {
											type : 'success',
											timer : 4000
										});

					});
</script>

</html>
