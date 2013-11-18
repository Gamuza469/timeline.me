package timeline.model;


public class Entidad {
	private int cuit;
	private String domicilio;
	private String telefono;
	private String email;
	
	public int getCuit() {
		return cuit;
	}
	public void setCuit(int cuit) {
		this.cuit = cuit;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
