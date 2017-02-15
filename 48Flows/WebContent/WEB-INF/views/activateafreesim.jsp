<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Activate a Free Sim</title>
<meta name = "viewport" content = "width = device-width, initial-scale = 1.0">
<script src="<spring:url value="/resources/js/jquery.min.js"/>"></script> 
<link rel="stylesheet" href="<spring:url value="/resources/css/style.css"/>">
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-toggle.min.css"/>">
<script src="<spring:url value="/resources/js/bootstrap-toggle.min.js"/>"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap.min.css"/>">

<!-- Optional theme -->
<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-theme.min.css"/>">

<!-- Latest compiled and minified JavaScript -->
<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<spring:url value="/resources/js/jquery.min.js"/>"></script>
	<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script>
		$(document).ready(function () {
			$('.dropdown-toggle').dropdown();
		});
		
	</script> 
	<link rel="stylesheet" type="text/css" media="screen" href="<spring:url value="/resources/css/jquery.fancybox-1.3.4.css"/>">


<link rel="stylesheet" href="https://www.google.com/fonts#QuickUsePlace:quickUse/Family:Lobster" type="text/css">
<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/nik.css"/>">
</head>
<% if (session.getAttribute("name")!=null){
	%><jsp:include page="logoutheader.jsp"/><%
}
else
{
%> <jsp:include page="loginheader.jsp"/> <%	
}
%>
<body>
<hr/>

<div align="center"><h3><u>Activate a 48 Sim Flow</u></h3></font>
</div>
<br/>
<div align="center">
<p>To Activate a 48 Sim Goto the <b><a href="http://localhost"><u>48Homepage</u></a></b> and click on the button <b><a href="http://localhost/activate-sim"><u>Activate a 48 Sim</u></a></b>.
<br/>
<hr/>


<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/activateasim/activateasim1.png"/>" height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><center><h4><a><u>Activate a 48 sim</a></u></h4><p> The buttons for Activating a sim in 48 are as shown in Screenshot.</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>




<img class="fancybox" id="float_rig" src="<spring:url value="/resources/images/activateasim/activateasim2.png"/>"  height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u>
<a href ="<spring:url value="/resources/files/ActivateSimController.php"/>" download="ActivateSimController.php">ActivateSimController.php</a></u></h4><p>The Controller for Order a freesim is present in the file <b>ActivateSimController.php</b> file. </p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/activateasim/activateasim3.png"/>"   height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a>Registration code</a></u></h4><p>This is responsible for validating the code which is present in the <b>registration-code.phtml</b> .</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_rig" src="<spring:url value="/resources/images/activateasim/activateasim4.png"/>"   height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a>Activate a sim Page</a></u><br/></h4><p>This is the page where we need to activate a sim using the <b>code</b> provided.</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/activateasim/activateasim5.png"/>"   height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a>Activate a Sim Form</a></u></h4><p>After Successfully entering the <b>Activation code</b> the user details needs to filled in to activate the sim. </p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_rig" src="<spring:url value="/resources/images/activateasim/activateasim6.png"/>"   height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="<spring:url value="/resources/files/account-singup.phtml"/>" download="account-singup.phtml">Account-singup.phtml</a></u><br/></h4><p>The above Page i.e Activate a Sim Page is displayed from the <b>Account-signup.phtml</b></p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>

<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/activateasim/activateasim7.png"/>"   height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="<spring:url value="/resources/files/account-singup2.phtml"/>" download="account-singup.phtml">Account-singup.phtml</a></u><br/></h4><p>The above Form i.e Activate a Sim Form is displayed from the <b>Account-signup.phtml</b></p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_rig" src="<spring:url value="/resources/images/activateasim/activateasim8.png"/>"   height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="<spring:url value="/resources/files/sidebar.phtml"/>" download="sidebar.phtml">Side Bar</a></u><br/></h4><p>The <b>Side bar</b> is being displayed from the <b>sidebar.phtml</b> File.</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/activateasim/activateasim9.png"/>"   height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a>MSISDN Selection</a></u></h4><p>After the submittion of the details the user has an option to select <b>a new MISDN or an existing MISDN</b>.</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_rig" src="<spring:url value="/resources/images/activateasim/activateasim10.png"/>"   height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="<spring:url value="/resources/files/portin-options.phtml"/>" download="Portin-options.phtml">Portin-options.phtml</a></u><br/></h4><p>If the user select's <b>I want to keep my number</b> the <b>Portin-options.phtml</b>	File is called.</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>




<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/activateasim/activateasim12.png"/>"   height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href ="<spring:url value="/resources/files/PortinOptions.php"/>" download="portin-options.php">portin-options.php</a></u><br/></h4><p>The <b>Portin-options.php</b> file is invoked by the above <b>portin-options.phtml</b> file</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_rig" src="<spring:url value="/resources/images/activateasim/activateasim13.png"/>"   height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a href="<spring:url value="/resources/files/portin-new_number.phtml"/>">portin-new_number</a></u></h4><p>For Portin the <b>portin-new_number.phtml</b> is called.</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/activateasim/activateasim14.png"/>"   height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a>Activate a Sim </a></u><br/></h4><p>Screenshot of Activate my sim page with <b> I want to keep my number </b> option selected .</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>




<img class="fancybox" id="float_rig" src="<spring:url value="/resources/images/activateasim/activateasim16.png"/>"   height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a>Activate a Sim</a></u><br/></h4><p>Screenshot of Activate my sim page with option <b>I want a new number </b>selected .</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_lef" src="<spring:url value="/resources/images/activateasim/activate a sim (backend log).png"/>"   height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a>Activate a new Sim Backend logs</a></u></h4><p>This screenshot consist of the restcalls and the methods being made to the backend.</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<img class="fancybox" id="float_rig" src="<spring:url value="/resources/images/activateasim/activate a sim (fontend log).png"/>"   height="40%" width="55%" style="visibility:visible">
<div align="left">
<br/><br/><br/><br/><br/><br/><br/><br/><center><h4><u><a>Activate a new Sim Frontend logs</a></u></h4><p>This screenshot consist of the restcalls being made by the Frontend.</p></center>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><hr/>


<script type="text/javascript" src="<spring:url value="/resources/js/jquery-1.11.0.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/jquery-migrate-1.2.1.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/jquery.fancybox-1.3.4.pack.min.js"/>"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/nik.js"/>"></script>
</body>
</html>