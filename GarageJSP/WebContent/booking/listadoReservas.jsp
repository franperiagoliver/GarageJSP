<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.*" %>
<%@page import="com.everis.alicante.becajava.domain.*" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>GARAGE MANAGMENT APP</title>
</head>
<body>
	
	LISTA DE RESERVAS </br>
	
	<br/>
	<div>
	<form method="get" action="/GarageJSP/dispatcher?option=8">
	<c:forEach items="${reservas}" var="reserva">
	
		<c:out value="${reserva}"></c:out>
		<a href="/GarageJSP/dispatcher?option=8&id=${reserva.idbooking}">Editar</a>
		<br/><br/>
	
	</c:forEach>
	</form>
	</div>
	
</body>
</html>