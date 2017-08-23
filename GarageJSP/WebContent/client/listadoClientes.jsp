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
<h1>LISTADO DE CLIENTES</h1>
<table border="1" align="center">
	<tr><th>ID</th>
	<th>Nombre</th>
	<th>Apellidos</th>
	<th>Nif</th>
	<th>Teléfono</th>
	<th>Reservas</th>
	<th>Vehículos</th>
	<th>¿Editar?</th></tr>
	<form method="get" action="/GarageJSP/dispatcher?option=9">
	<c:forEach items="${clientes}" var="cliente">
		<tr><td><c:out value="${cliente.idclient}"></c:out></td>
		<td><c:out value="${cliente.name}"></c:out></td>
		<td><c:out value="${cliente.surname}"></c:out></td>
		<td><c:out value="${cliente.nif}"></c:out></td>
		<td><c:out value="${cliente.telephone}"></c:out></td>
		<td>
		<c:forEach items="${cliente.bookings}" var="reserva">
		<c:out value="${reserva}"></c:out>
		</c:forEach>
		</td>
		<td>
		<c:forEach items="${cliente.vehicles}" var="vehiculo">
		<c:out value="${vehiculo}"></c:out>
		</c:forEach>
		</td>
		<td><a href="/GarageJSP/dispatcher?option=9&id=${cliente.idclient}">Editar</a></td></tr>
	</c:forEach>
	</form>
</table>
</body>
</html>