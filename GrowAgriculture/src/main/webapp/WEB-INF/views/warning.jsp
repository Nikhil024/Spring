<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html lang="en">
<head>

</head>
<body>

	<div class="alert alert-warning">
		<button type="button" aria-hidden="true" class="close">×</button>
		<span><b> Warning - </b> ${warningmessage} </span>
	</div>

	<jsp:include page="uploadform.jsp" />
</body>
</html>
