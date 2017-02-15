<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Verification Success</title>
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
      <b>Success Alert:</b> Yuhuuu! ${ name } Your email validation is a success ...! Now login and try..!
    </div>
</div>
<jsp:include page="Login.jsp"/>
</body>
</html>