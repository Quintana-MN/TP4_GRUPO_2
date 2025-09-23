<%@ page import="dominio.Seguro" %>
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

<form action="servletFiltro" method="get">
Busqueda por tipos de seguros <select name="tipoSeguro">
			<option value="1">Seguro de Casas</option>
			<option value="2">Seguro de Vida</option>
			<option value= "3">Seguro de motos</option>
		</select>
		<input type="submit" name="fitrarTabla" value="Filtro"> 
</form>


<%

	ArrayList<Seguro> listaFiltro;
	if(request.getAttribute("filtroU")!=null)
	{
		listaFiltro = (ArrayList<Seguro>)request.getAttribute("filtroU");
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
	for(Seguro seg : listaFiltro)
	{
%>

<tr>
<td><%=seg.getIdSeguro()%></td>
<td><%=seg.getDescripcion()%></td>
<td><%=seg.getIdTipoSeguro()%></td>
<td><%=seg.getCostoContratacion()%></td>
<td><%=seg.getCostoMaximoAsegurado()%></td>
</tr>

<%} %>
</table>



</body>
</html>
