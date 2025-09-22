<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dominio.DaoSeguro"%>
<%@page import="dominio.Seguro"%>
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
		<td>Descripción:</td> <td><input type="text" name="txtDescripcion"></td>
		</tr>
		<tr>
		<td>Tipo de Seguro:</td>
		<td><select name="tipoSeguro">
			<option value="1">Seguro de Casas</option>
			<option value="2">Seguro de Autos</option>
			<option value="3">Seguro de motos</option>
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

		</tr>
		</table>
	</form>
	<%
	    int filas = 0;
	    if (request.getParameter("btnAceptar") != null) {
	        String descripcion = request.getParameter("txtDescripcion");
	        String tipoSeguroStr = request.getParameter("tipoSeguro");
	        String contratacionStr = request.getParameter("txtContratacion");
	        String costoAsegStr = request.getParameter("txtCostoAseg");
			
	        Seguro seguro = new Seguro();
			seguro.setIdTipoSeguro(Integer.parseInt(tipoSeguroStr));
			seguro.setCostoContratacion(Integer.parseInt(contratacionStr));
			seguro.setCostoMaximoAsegurado(Integer.parseInt(costoAsegStr));
			seguro.setDescripcion(descripcion);

	        DaoSeguro daoSeguro = new DaoSeguro();
	        filas = daoSeguro.agregarSeguro(seguro);
			
		}
		%>
		<%
			if (filas > 0) 
			{
	            out.println("<p>Seguro agregado correctamente.</p>");
	        } else {
	            out.println("<p>Error al agregar el seguro.</p>");
	        }
	%>

</fieldset>
</body>
</html>