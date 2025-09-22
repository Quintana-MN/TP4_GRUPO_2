package dominio;

public class Seguro {
	private int idSeguro;
	private String descripcion;
	private int idTipoSeguro;
	private int costoContratacion;
	private int costoMaximoAsegurado;
	
	public Seguro() {
		
	};
	
	public Seguro(int idSeg,String desc,int idTipoSeg,int costoContrat,int costoMaximoAseg) {
		idSeguro=idSeg;
		descripcion=desc;
		idTipoSeguro=idTipoSeg;
		costoContratacion=costoContrat;
		costoMaximoAsegurado=costoMaximoAseg;
	}
	
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdTipoSeguro() {
		return idTipoSeguro;
	}
	public void setIdTipoSeguro(int idTipoSeguro) {
		this.idTipoSeguro = idTipoSeguro;
	}
	public int getCostoContratacion() {
		return costoContratacion;
	}
	public void setCostoContratacion(int costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	public int getCostoMaximoAsegurado() {
		return costoMaximoAsegurado;
	}
	public void setCostoMaximoAsegurado(int costoMaximoAsegurado) {
		this.costoMaximoAsegurado = costoMaximoAsegurado;
	}
	

	
}
