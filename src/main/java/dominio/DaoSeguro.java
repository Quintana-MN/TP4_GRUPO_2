package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Seguro;

import dominio.seguroConDescTipo;


public class DaoSeguro {
	public String host="jdbc:mysql://localhost:3306/";
	private String user="root";
	private String pass="0909";
	private String dbName= "segurosgroup";
	
	public DaoSeguro() {
		
	}
	
	public int agregarSeguro(Seguro seguro) {
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		String query = "INSERT INTO seguros(descripcion, idTipo, costoContratacion, costoAsegurado) VALUES ('"
			    + seguro.getDescripcion() + "', "
			    + seguro.getIdTipoSeguro() + ", "
			    + seguro.getCostoContratacion() + ", "
			    + seguro.getCostoMaximoAsegurado() + ")";
		Connection cn = null;
		int filas= 0;
	
		try {
			cn=DriverManager.getConnection(host+dbName,user,pass);
			Statement st= cn.createStatement();
			filas= st.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	
	// LISTA DE TIPOS DE SEGUROS
	public ArrayList<tipoSeguro> listarTipoSeguros()
	{
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		ArrayList<tipoSeguro> listaTipoSeguros = new ArrayList<tipoSeguro>();
		String query = "Select * from tiposeguros";
		
		Connection conec = null;
		
		try {
			conec = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = conec.createStatement();
			ResultSet rst = st.executeQuery(query);
			
			while(rst.next()) {
				tipoSeguro ts = new tipoSeguro ();
				ts.setTipoSeguro((rst.getInt("idTipo")));
				ts.setDescripcion(rst.getString("descripcion"));
			
				listaTipoSeguros.add(ts); 
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return listaTipoSeguros;
	}
	
	
	// LISTA DE SEGUROS
	public ArrayList<seguroConDescTipo> listarSeguros()
	{
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    ArrayList<seguroConDescTipo> listarSeguros = new ArrayList<seguroConDescTipo>();
	    String query = "SELECT s.idSeguro, s.descripcion AS descripcionSeguro, s.costoContratacion, s.costoAsegurado, t.descripcion AS descripcionTipo " +
	                   "FROM seguros s JOIN tiposeguros t ON s.idTipo = t.idTipo";

	    Connection conec = null;

	    try {
	        conec = DriverManager.getConnection(host + dbName, user, pass);
	        Statement st = conec.createStatement();
	        ResultSet rst = st.executeQuery(query);

	        while(rst.next()) {
	            seguroConDescTipo seg = new seguroConDescTipo();

	            seg.setIdSeguro(rst.getInt("idSeguro"));
	            seg.setDescripcion(rst.getString("descripcionSeguro"));
	            seg.setDescripcionTipoSeguro(rst.getString("descripcionTipo"));
	            seg.setCostoContratacion(rst.getInt("costoContratacion"));
	            seg.setCostoMaximoAsegurado(rst.getInt("costoAsegurado"));

	            listarSeguros.add(seg); 
	        }
	        conec.close();
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }

	    return listarSeguros;
	}

	
	
	// CONSULTA SELECT PARA OBTENER EL PROXIMO ID SEGURO
	public int obtenerProximoIdSeguro() {
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
	    int proximoId = 0;
	    Connection cn = null;
	    
	    try {
	        cn = DriverManager.getConnection(host + dbName, user, pass);
	        Statement st = cn.createStatement();
	        String query = "SELECT MAX(idSeguro) AS ultimoId FROM seguros";
	        ResultSet rs = st.executeQuery(query);
	        
	        rs.next();
	        proximoId = rs.getInt("ultimoId") + 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	    
	    return proximoId;
	}
	
	public ArrayList<seguroConDescTipo> filtrarSeguros(int id) {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    ArrayList<seguroConDescTipo> listaSegurosFiltrados = new ArrayList<seguroConDescTipo>();
	    String query = "SELECT s.idSeguro, s.descripcion AS descripcionSeguro, s.idTipo, s.costoContratacion, s.costoAsegurado"
	    		+ "		, tipoSeg.descripcion AS descripcionTipo " +
	                   "FROM seguros s " +
	                   "JOIN tiposeguros tipoSeg ON s.idTipo = tipoSeg.idTipo " +
	                   "WHERE s.idTipo = ?";

	    Connection conec = null;

	    try {
	        conec = DriverManager.getConnection(host + dbName, user, pass);
	        PreparedStatement pst = conec.prepareStatement(query);
	        pst.setInt(1, id);
	        ResultSet rst = pst.executeQuery();

	        while (rst.next()) {
	            seguroConDescTipo seg = new seguroConDescTipo();

	            seg.setIdSeguro(rst.getInt("idSeguro"));
	            seg.setDescripcion(rst.getString("descripcionSeguro"));
	            seg.setIdTipoSeguro(rst.getInt("idTipo"));
	            seg.setDescripcionTipoSeguro(rst.getString("descripcionTipo"));
	            seg.setCostoContratacion(rst.getInt("costoContratacion"));
	            seg.setCostoMaximoAsegurado(rst.getInt("costoAsegurado"));

	            listaSegurosFiltrados.add(seg);
	        }
	        conec.close();
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }

	    return listaSegurosFiltrados;
	}
}
