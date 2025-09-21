package dominio;

public class tipoSeguro {
  private int tipoSeguro;
  private String descripcion;

public tipoSeguro() {
	  
}
  
public tipoSeguro(int tipoSeguro,String descripcion) 
{
	 this.tipoSeguro =  tipoSeguro;
	 this.descripcion = descripcion;
}
  
public int getTipoSeguro() {
	return tipoSeguro;
}

public void setTipoSeguro(int tipoSeguro) {
	this.tipoSeguro = tipoSeguro;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
  
}
