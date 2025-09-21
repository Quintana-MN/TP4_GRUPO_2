package dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import dominio.Seguro;


public class DaoSeguro {
	public String host="jdbc:mysql://localhost:3306/";
	private String user="root";
	private String pass="root";
	private String dbName= "segurosgroup";
	
	public DaoSeguro() {
		
	}
	
	public int agregarSeguro(Seguro seguro) {
		
		String query = "INSERT INTO Seguro(descripcion, idTipo, costoContratacion, costoAsegurado) VALUES ('"
			    + seguro.getDescripción() + "', "
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
	
	

}
