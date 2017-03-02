<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!doctype html>
<html lang="en">
<head>
	<jsp:include page="Header.jsp"/>
</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="orange" data-image="<spring:url value="/resources/img/${bgimagename}"/>">
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
				<select name="cities" class="selectpicker"
					data-title="Single Select" data-style="btn-default btn-block"
					data-menu-style="dropdown-blue">
					<option value="id">Bahasa Indonesia</option>
					<option value="ms">Bahasa Melayu</option>
					<option value="ca">Català</option>
					<option value="da">Dansk</option>
					<option value="de">Deutsch</option>
					<option value="en">English</option>
					<option value="es">Español</option>
					<option value="el">Eλληνικά</option>
					<option value="fr">Français</option>
					<option value="it">Italiano</option>
					<option value="hu">Magyar</option>
					<option value="nl">Nederlands</option>
					<option value="no">Norsk</option>
					<option value="pl">Polski</option>
					<option value="pt">Português</option>
					<option value="fi">Suomi</option>
					<option value="sv">Svenska</option>
					<option value="tr">Türkçe</option>
					<option value="is">Íslenska</option>
					<option value="cs">Čeština</option>
					<option value="ru">Русский</option>
					<option value="th">ภาษาไทย</option>
					<option value="zh">中文 (简体)</option>
					<option value="zh-TW">中文 (繁體)</option>
					<option value="ja">日本語</option>
					<option value="ko">한국어</option>
				</select>
			</div>
		</div>
	</div>
</div>
</div>


</body>
</html>