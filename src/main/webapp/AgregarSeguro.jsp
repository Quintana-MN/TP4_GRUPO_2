<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página Agregar Seguro</title>
</head>
<body>
<fieldset>
	<header>
	<a href="Inicio.jsp">Inicio</a>
	<a href="AgregarSeguro.jsp">Agregar Sucursal</a>
	<a href="ListarSeguros.jsp">Listar Seguros</a>
	</header>
	
	<h1>Agregar Seguro</h1>
	
	<form action="AgregarSeguro.jsp" method="get">
	<table>
		<tr>
		<td>Id Seguro:</td><td><span></span></td>
		</tr>
		<tr>
		<td>Descripción:</td> <td><input type="text" name="txtDescipcion"></td>
		</tr>
		<tr>
		<td>Tipo de Seguro:</td>
		<td><select name="tipoSeguro">
			<option>Seguro de Casas</option>
			<option>Seguro de Autos</option>
			<option>Seguro de motos</option>
		</select>
			</td>
			</tr>
		<tr>
		<td>Costo contratación:</td> <td><input type="text" name="txtContratacion"></td>
		</tr>
		<tr>
		<td>Costo Máximo Asegurado:</td> <td><input type="text" name="txtCostoAseg"></td>
		</tr>
		<tr>
		<td></td> <td><input type="submit" name="btnAceptar" value = "Aceptar"></td>
		</tr>
		<tr>
		<td><input type="submit" name="btnAceptar" value = "Aceptar"></td>

		</tr>
		</table>
	</form>
</fieldset>
</body>
</html>