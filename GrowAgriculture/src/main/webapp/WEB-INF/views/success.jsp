<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>


<body>

<jsp:include page="${page}"/>
<div class="alert alert-success">
    <div class="container-fluid">
	  <div class="alert-icon">
		<i class="material-icons">check</i>
	  </div>
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		<span aria-hidden="true"><i class="material-icons">clear</i></span>
	  </button>
      <b>Success Alert:</b> ${success}
    </div>
</div>
<script>
  setTimeout(function() {
      document.location = "<spring:url value="/${redirect}"/>";
  }, 3000);
</script>
</body>

</html>