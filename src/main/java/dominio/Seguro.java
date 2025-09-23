package dominio;

public class Seguro {
	private int idSeguro;
	private String descripcion;
	private int idTipoSeguro;
	private double costoContratacion;
	private double costoMaximoAsegurado;
	
	public Seguro() {
		
	}
	
	public Seguro(int idSeg, String desc, int idTipoSeg, double costoContrat, double costoMaximoAseg) {
		idSeguro = idSeg;
		descripcion = desc;
		idTipoSeguro = idTipoSeg;
		costoContratacion = costoContrat;
		costoMaximoAsegurado = costoMaximoAseg;
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
	
	public double getCostoContratacion() {
		return costoContratacion;
	}
	public void setCostoContratacion(double costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	
	public double getCostoMaximoAsegurado() {
		return costoMaximoAsegurado;
	}
	public void setCostoMaximoAsegurado(double costoMaximoAsegurado) {
		this.costoMaximoAsegurado = costoMaximoAsegurado;
	}	
}
