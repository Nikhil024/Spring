<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Failed</title>
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
      <b>Error Alert:</b> Damn man! You screwed up the server this time. You should enter all details properly...
    </div>
</div>

<%-- <center><h1><font color="red"> Please enter ${ error } details ..! </h1></font></center> --%>
<jsp:include page="register.jsp"/>
</body>
</html>