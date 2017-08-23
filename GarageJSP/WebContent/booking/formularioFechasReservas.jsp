<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GARAGE MANAGEMENT APP</title>
</head>
<body>
<form method="post" action="/GarageJSP/bookingDate">
		<h2>ELIGE LA FECHA DE INICIO Y DE FIN</h2>
		<h3>Fecha de inicio:</h3>
		<input type="date" name="fechaInicio" step="1"/><br/>
		<h3>Fecha de fin: </h3>
		<input type="date" name="fechaFin" step="1"/><br/><br/>
		<input type="hidden" name="filtroFecha" value="filtroFecha"/>
		<input type="submit" value="Listar reservas" name="ListarFec" />
	</form>

</body>
</html>