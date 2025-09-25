<%@ page import="dominio.Seguro" %>
<%@ page import="dominio.seguroConDescTipo" %>
<%@ page import="java.util.ArrayList" %>
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
		<a href="servletSeguro?MostrarSeguros=1">Listar Seguros</a>
	</header>
	
	<h1>Tipos de seguros en la base de datos</h1>
	
	<form action="servletSeguro" method="post">
		Busqueda por tipos de seguros
		<select name="tipoSeguro">
			<option value="1">Seguro de Casas</option>
			<option value="2">Seguro de Vida</option>
			<option value="3">Seguro de motos</option>
		</select>
		<input type="submit" name="fitrarTabla" value="Filtro"> 
	</form>
		
	<%
		ArrayList<seguroConDescTipo> lista = null;
		if(request.getAttribute("listaS") != null) {
			lista = (ArrayList<seguroConDescTipo>) request.getAttribute("listaS");
		}
	%>
	
	<table border="1">
		<tr>
			<th>ID Seguro</th>
			<th>Descripción Seguro</th>
			<th>Descripción Tipo Seguro</th>
			<th>Costo Contratación</th>
			<th>Costo Máximo Asegurado</th>
		</tr>
		
		<%
		    if (lista != null)
			for(seguroConDescTipo seg : lista) {
		%>		
				<tr>
					<td><%= seg.getIdSeguro() %></td>
					<td><%= seg.getDescripcion() %></td>
					<td><%= seg.getDescripcionTipoSeguro() %></td>
					<td><%= seg.getCostoContratacion() %></td>
					<td><%= seg.getCostoMaximoAsegurado() %></td>
				</tr>	
		<%
			}
		%>
	</table>
</body>
</html>
