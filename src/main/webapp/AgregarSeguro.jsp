<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página Agregar Seguro</title>
</head>
<body>
	<a href="Inicio.jsp">Inicio</a>
	<a href="ListarSeguros.jsp">Listar Seguros</a>
	<a href="AgregarSeguro.jsp">Agregar Sucursal</a>
	
	<h1>Agregar Seguro</h1>
	
	<form action="AgregarSeguro.jsp" method="get">
		Id Seguro: <span></span> <br>
		Descripción: <input type="text" name="txtDescipcion"><br>
		Tipo de Seguro:
		<select name="tipoSeguro">
			<option>Seguro de Casas</option>
			<option>Seguro de Autos</option>
		</select><br>
	</form>
</body>
</html>