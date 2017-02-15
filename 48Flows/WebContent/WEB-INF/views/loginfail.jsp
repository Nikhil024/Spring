<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Failed Login</title>
<script>
  setTimeout(function() {
      document.location = "http://172.30.55.7:1234/48Flows/login";
  }, 8000); 
</script>
</head>
<body>

<div class="alert alert-danger">
    <div class="container-fluid">
	  <div class="alert-icon">
	    <i class="material-icons">error_outline</i>
	  </div>
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		<span aria-hidden="true"><i class="material-icons">clear</i></span>
	  </button>
      <b>Error Alert:</b> Damn ... Your'e Username or Password is wrong ..!
    </div>
</div>



<%-- <center><h1>Failed to Login because of invalid ${ data }</h1></center> --%>

<jsp:include page="Login.jsp"/>
</body>
</html>