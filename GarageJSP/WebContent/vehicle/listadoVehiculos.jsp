<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GARAGE MANAGEMENT APP</title>
</head>
<body>
<div>
<form method="get" action="/GarageJSP/dispatcher?option=10">
<h1>LISTADO DE VEHICULOS</h1>
	<c:forEach items="${vehiculos}" var="vehiculo">
		<c:out value="${vehiculo}"></c:out>
		<a href="/GarageJSP/dispatcher?option=10&id=${vehiculo.idvehicle}">Editar</a>
		<br/><br/>
	</c:forEach>
</form>
</div>
</body>
</html>