<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html lang="en">
<head>
<jsp:include page="Header.jsp" />
</head>
<body>

	<div class="wrapper">
		<div class="sidebar" data-color="orange"
			data-image="<spring:url value="/resources/img/${bgimagename}"/>">
			<!--

            Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
            Tip 2: you can also add an image using data-image tag

        -->

			<div class="sidebar-wrapper">
				<jsp:include page="sidebar.jsp"></jsp:include>
			</div>
		</div>
		<div class="main-panel">
			<div class="col-md-6">
				<legend>Select Subject</legend>
				<div class="row">
					<div class="col-md-6">
						<select multiple data-title="Select Subjects" name="currency"
							class="selectpicker" data-style="btn-info btn-fill btn-block"
							data-menu-style="dropdown-blue">
							<option value="ARS">ARS</option>
							<option value="AUD">AUD</option>
							<option value="BRL">BRL</option>
							<option value="CAD">CAD</option>
							<option value="CHF">CHF</option>
							<option value="CNY">CNY</option>
							<option value="CZK">CZK</option>
							<option value="DKK">DKK</option>
							<option value="EUR">EUR</option>
							<option value="GBP">GBP</option>
							<option value="HKD">HKD</option>
							<option value="HUF">HUF</option>
							<option value="IDR">IDR</option>
							<option value="ILS">ILS</option>
							<option value="INR">INR</option>
							<option value="JPY">JPY</option>
							<option value="KRW">KRW</option>
							<option value="MYR">MYR</option>
							<option value="MXN">MXN</option>
							<option value="NOK">NOK</option>
							<option value="NZD">NZD</option>
							<option value="PHP">PHP</option>
							<option value="PLN">PLN</option>
							<option value="RUB">RUB</option>
							<option value="SEK">SEK</option>
							<option value="SGD">SGD</option>
							<option value="TWD">TWD</option>
							<option value="USD">USD</option>
							<option value="VND">VND</option>
							<option value="ZAR">ZAR</option>
						</select>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>