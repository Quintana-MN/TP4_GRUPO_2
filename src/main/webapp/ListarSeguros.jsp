<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página Listar Seguros</title>
</head>
<body>
<a href="Inicio.jsp">
Inicio
</a>
<br>
<a href="AgregarSeguro.jsp">
Agregar Seguros
</a>
<h1>Tipos de Datos</h1>
<br>
Busqueda por tipos de seguros <select name="tipoSeguro">
			<option>Seguro de Casas</option>
			<option>Seguro de Autos</option>
			<option>Seguro de motos</option>
		</select>
		<input type="submit" name="fitrarTabla" value="Filtro"> 


</body>
</html>
