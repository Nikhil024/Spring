<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.growagro.Bean.UserDetailsBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html lang="en">
<body>
	<div class="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="main-panel">
			<div class="col-md-12">
				<div class="card card-plain">
					<div class="header">
						<h4 class="title">Table on Plain Background</h4>
						<p class="category">Here is a subtitle for this table</p>
					</div>
					<div class="content table-responsive table-full-width">
						<table class="table table-hover">
							<thead>
								<th>Id</th>
								<th>Name</th>
								<th>Email</th>
								<th>Address</th>
							</thead>
							<tbody>
								<%
						try{
						List<Integer> id = (ArrayList) session.getAttribute("id");
						List<String> name = (ArrayList) session.getAttribute("name");
						List<String> email = (ArrayList) session.getAttribute("email");
						List<String> address = (ArrayList) session.getAttribute("address");
						for(int i = 0;i<id.size();i++){
							System.out.println("<id "+id.get(i));
							System.out.println("<name "+name.get(i));
							System.out.println("<email "+email.get(i));
							System.out.println("<address "+address.get(i));
						
						%>
								<tr>
									<td><%=id.get(i)%></td>
									<td><%=name.get(i)%></td>
									<td><%=email.get(i)%></td>
									<td><%=address.get(i)%></td>
								</tr>
								<%}}
						catch(Exception e){
							System.out.println(e);
						}%>
							</tbody>
						</table>

					</div>
				</div>
			</div>
		</div>


	</div>