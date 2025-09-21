<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página Listar Seguros</title>
</head>
<body>
<header>
	<a href="Inicio.jsp">Inicio</a>
	<a href="AgregarSeguro.jsp">Agregar Sucursal</a>
	<a href="ListarSeguros.jsp">Listar Seguros</a>
</header>
<h1>Tipos de seguros en la base de datos</h1>

Busqueda por tipos de seguros <select name="tipoSeguro">
			<option>Seguro de Casas</option>
			<option>Seguro de Autos</option>
			<option>Seguro de motos</option>
		</select>
		<input type="submit" name="fitrarTabla" value="Filtro"> 


<table border="1">
<tr>
<th>ID Seguro</th>
<th>Descripción Seguro</th>
<th>Descripción Tipo Seguro</th>
<th>Costo Contratación</th>
<th>Costo Máximo Asegurado</th>
</tr>

<tr>
<td></td>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</table>

</body>
</html>
