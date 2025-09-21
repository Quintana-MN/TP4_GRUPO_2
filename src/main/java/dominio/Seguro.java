package dominio;

public class Seguro {
	private int idSeguro;
	private String descripción;
	private int idTipoSeguro;
	private int costoContratacion;
	private int costoMaximoAsegurado;
	
	
	
	public Seguro(int idSeg,String desc,int idTipoSeg,int costoContrat,int costoMaximoAseg) {
		idSeguro=idSeg;
		descripción=desc;
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
	public String getDescripción() {
		return descripción;
	}
	public void setDescripción(String descripción) {
		this.descripción = descripción;
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
