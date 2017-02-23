<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html lang="en">
<head>
	<jsp:include page="Header.jsp"></jsp:include>
    
</head>
<body> 


<nav class="navbar navbar-transparent navbar-absolute">
    <div class="container">    
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">${projectname}</a>
        </div>
        <div class="collapse navbar-collapse">       
            
            <ul class="nav navbar-nav navbar-right">

            </ul>
        </div>
    </div>
</nav>

<div class="wrapper wrapper-full-page">
    
    <div class="full-page lock-page" data-color="orange" data-image="<spring:url value="/resources/img/${bgimagename}"/>">   
        
    <!--   you can change the color of the filter page using: data-color="blue | azure | green | orange | red | purple" -->
        <div class="content">
            <form method="#" action="#">
                <div class="user-profile">        
                    <div class="author">
                    	<c:if test="${nopicture == 'YES'}">
								<img
									src="<spring:url value="/resources/img/${userprofileimage}"/>" />
							</c:if>

							<c:if test="${picture == 'YES'}">
								<img
									src="<spring:url value="/images/profile/${userprofileimage}"/>" width="100%" height="100%" />
							</c:if>
                    
                       <!--  <img class="avatar" src="../../assets/img/default-avatar.png" alt="..."> -->
                    </div> 
                    <h4>${name}</h4> 
                    <div class="form-group">
                        <input type="password" placeholder="Enter Password" class="form-control">
                    </div>
                    <button type="button" class="btn btn-neutral btn-round btn-fil btn-wd">Unlock</button> 
                                                    
                </div>
                
            </form>
            <div class="col-md-4 col-sm-6 col-md-offset-4 col-sm-offset-3" style="margin-top: 330px;margin-right: 14px;margin-left: 500px;">
              <c:if test="${fail == 'show'}">
								<div class="alert alert-danger">
									<span><b> Error - </b> ${data}</span>
								</div>
							</c:if>

							<c:if test="${success == 'show'}">
								<div class="alert alert-success">
									<span><b> Success - </b> ${data}</span>
								</div>
							</c:if> 
							</div>
        </div>
        
        
    </div> 
   
</div>




</body>    
</html>