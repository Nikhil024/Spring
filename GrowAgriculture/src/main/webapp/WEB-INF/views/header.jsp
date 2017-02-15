<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="com.growagro.Data.PropertiesfileReading" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="<spring:url value="/resources/img/dashboard/apple-icon.png"/>">
	<link rel="icon" type="image/png" sizes="96x96" href="<spring:url value="/resources/img/dashboard/favicon.png"/>">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<% if (session.getAttribute("header") == null && session.getAttribute("usertype") == null){
	String header = PropertiesfileReading.getProperty("defaultheadervalue");
	String usertype = PropertiesfileReading.getProperty("defaultusertypevalue");
}
else{
String header = session.getAttribute("header").toString();
String usertype = session.getAttribute("usertype").toString();
System.out.println("header : "+header);
%>
	<title>Grow Agriculture <%=header %></title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="<spring:url value="/resources/css/dashboard/bootstrap.min.css"/>" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="<spring:url value="/resources/css/dashboard/animate.min.css"/>" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="<spring:url value="/resources/css/dashboard/paper-dashboard.css"/>" rel="stylesheet"/>


    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="<spring:url value="/resources/css/dashboard/themify-icons.css"/>" rel="stylesheet">

</head>
<body>

	<div class="sidebar" data-background-color="black" data-active-color="danger">

    <!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="<spring:url value="/"/>" class="simple-text">
                    Grow Agriculture
                </a>
            </div>
	
            <ul class="nav">
             <li>
                <% if(header.equals("dashboard")){ %><li class="active"><%} %>
                    <a href="<spring:url value="/dashboard"/>">
                        <i class="ti-panel"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <li>
                  <% if(header.equals("profile")){ %><li class="active"><%} %>
                    <a href="<spring:url value="/profile"/>">
                        <i class="ti-user"></i>
                        <p>User Profile</p>
                    </a>
                </li>
                <li>
                  <% if(header.equals("farmerlist")){%><li class="active"><%} %>
                    <a href="<spring:url value="/farmerslist"/>">
                        <i class="ti-bolt"></i>
                        <p>Farmers List</p>
                    </a>
                </li>
                 <li>
                   <% if(usertype.equals(PropertiesfileReading.getProperty("farmer"))){
                   if(header.equals("upld")){ %><li class="active"><%} %>
                    <a href="<spring:url value="upload"/>">
                        <i class="ti-view-list-alt"></i>
                        <p>Upload</p>
                    </a>
                    <%} %>
                </li>
                <li>
                  <% if(header.equals("logout")){ %><li class="active"><%} %>
                    <a href="<spring:url value="/logout"/>">
                        <i class="ti-share"></i>
                        <p>Logout</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>

</body>
<%} %>
    <!--   Core JS Files   -->
    <script src="<spring:url value="/resources/js/dashboard/jquery-1.10.2.js"/>" type="text/javascript"></script>
	<script src="<spring:url value="/resources/js/dashboard/bootstrap.min.js"/>" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="<spring:url value="/resources/js/dashboard/bootstrap-checkbox-radio.js"/>"></script>

	<!--  Charts Plugin -->
	<script src="<spring:url value="/resources/js/dashboard/chartist.min.js"/>"></script>

    <!--  Notifications Plugin    -->
    <script src="<spring:url value="/resources/js/dashboard/bootstrap-notify.js"/>"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="<spring:url value="/resources/js/dashboard/paper-dashboard.js"/>"></script>
</html>