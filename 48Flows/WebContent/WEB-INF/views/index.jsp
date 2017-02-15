<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
	<head>
	<link href="https://fonts.googleapis.com/css?family=Bungee+Shade" rel="stylesheet">
	<style>
	h1 {
	font-family: 'Bungee Shade', cursive;
	}
	
	</style>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge"> 
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <title>48 Flow Analysis Login Page</title>
        <meta name="description" content="Examples for creative website header animations using Canvas and JavaScript" />
        <meta name="keywords" content="header, canvas, animated, creative, inspiration, javascript" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico">
        <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/normalize.css"/>" />
        <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/demo.css"/>" />
        <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/component.css"/>"/>
        <link href='http://fonts.googleapis.com/css?family=Raleway:200,400,800|Clicker+Script' rel='stylesheet' type='text/css'>
	</head>
	<body>
		<div class="container demo-2">
			<div class="content">
			
                <div id="large-header" class="large-header">
                    <canvas id="demo-canvas"></canvas>
                    <h1 class="display-4">48Months<br/>click here to gotto index page</span></h1>
                    <h2>Welcome ${ name } to page</h2>
                    <p>this is a demo</p>
                </div>
                               
            </div>
          
           
		</div>
		
        <script src="<spring:url value="/resources/js/rAF.js"/>"></script>
        <script src="<spring:url value="/resources/js/demo-2.js"/>"></script>
	</body>
</html>