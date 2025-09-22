<%@page import="dominio.tipoSeguro"%>
<%@page import="java.util.ArrayList"%>
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
		
		<form action="servletSeguro" method="get">
			<table>
				<tr>
					<td>Id Seguro:</td><td><span></span></td>
				</tr>
				<tr>
					<td>Descripción:</td> <td><input type="text" name="txtDescripcion"></td>
				</tr>
				
				
				<!-- CARGA DE TIPOS DE SEGUROS -->
				<%
					ArrayList <tipoSeguro> listaTipoSeguros = null;
					if (request.getAttribute("listaTS") != null){
						listaTipoSeguros = (ArrayList <tipoSeguro>) request.getAttribute("listaTS");
					}
				%>
				<tr>
					<td>Tipo de Seguro:</td>
					<td>
						<select name="tipoSeguro">
							<%
								if(listaTipoSeguros != null)
								for (tipoSeguro ts : listaTipoSeguros)
								{
							%>
									<option><%= ts.getDescripcion() %></option>
							<%	
								}
							%>
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
					<td></td> <td><input type="submit" name="btnCargaTS" value = "Cargar Tipo de Seguros"></td>
				</tr>
				<tr>
					<td><input type="submit" name="btnAceptar" value = "Aceptar"></td>
				</tr>
			</table>
		</form>
	</fieldset>
		
		
		
		
		
		
		
		
		
		
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
</body>
</html>