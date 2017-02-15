<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Bangers|Bungee+Shade" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log out</title>
<style>
h1{
font-family: 'Bungee Shade', cursive;
font-family: 'Bangers', cursive;
}
</style>
<script>
  setTimeout(function() {
      document.location = "<spring:url value="/homepage"/>";
  }, 1000); // 
</script>
</head>
<body>
<%
Object demo = request.getAttribute("javax.servlet.forward.request_uri");
%>
<center><h1>Logging You out Please Wait ...!</h1></center>

</div>
</body>
</html>