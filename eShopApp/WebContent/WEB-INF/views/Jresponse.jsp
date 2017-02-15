<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Json</title>
</head>
<body>
	<h2>Json Response</h2>
</head>

<%

try
{
String filelocation = session.getAttribute("filelocation").toString();
BufferedReader input = new BufferedReader(new FileReader(filelocation));
String line = null;
while ((line=input.readLine()) != null)
{
   out.println(line.replace("}", "}</br></br>"));
}
out.flush();
session.removeAttribute("count");
session.removeAttribute("filelocation");
input.close();
}
catch(Exception e)
{
out.println(e);
}
%>
</body>
</html>