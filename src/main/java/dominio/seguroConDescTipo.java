package dominio;

public class seguroConDescTipo {
	private int idSeguro;
	private String descripcion;
	private int idTipoSeguro;
	private String descripcionTipoSeguro;
	private int costoContratacion;
	private int costoMaximoAsegurado;
	
	
	public seguroConDescTipo() {
		
	};
	
	public seguroConDescTipo(int idSeg,String desc,int idTipoSeg,String descTipoSeg,int costoContrat,int costoMaximoAseg) {
		idSeguro=idSeg;
		descripcion=desc;
		idTipoSeguro=idTipoSeg;
		costoContratacion=costoContrat;
		costoMaximoAsegurado=costoMaximoAseg;
		descripcionTipoSeguro=descTipoSeg;
	}
	public String getDescripcionTipoSeguro() {
		return descripcionTipoSeguro;
	}
	public void setDescripcionTipoSeguro(String descripcion) {
		this.descripcionTipoSeguro = descripcion;
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
