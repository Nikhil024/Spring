<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Bangers|Bungee+Shade" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Registrarion</title>
<style>
h1{
font-family: 'Bungee Shade', cursive;
font-family: 'Bangers', cursive;
}
</style>
<script>
  setTimeout(function() {
      document.location = "<spring:url value="/login"/>";
  }, 8000); // 
</script>
</head>
<body>



<div class="alert alert-success">
    <div class="container-fluid">
	  <div class="alert-icon">
		<i class="material-icons">check</i>
	  </div>
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		<span aria-hidden="true"><i class="material-icons">clear</i></span>
	  </button>
      <b>Success Alert:</b> Yuhuuu! You've successfully registered with us.Please verify your mail by using the link sent to your mail...
    </div>
</div>





<!-- <h1>Successfully registered. <br/>Please verify your mail by using the link sent to your mail.<br/>Please Wait while redirecting to Login page</h1> -->
<jsp:include page="register.jsp"/>
</body>
</html>