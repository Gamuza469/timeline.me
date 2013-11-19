package timeline.model;

import java.util.List;

public class Agente {
	private String nombre;
	private String apellido;
	private Entidad datosDeEntidad;
	private int empresaContratante;
	private List<Empresa> empresasEnSeguimiento;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Entidad getDatosDeEntidad() {
		return datosDeEntidad;
	}
	public void setDatosDeEntidad(Entidad datosDeEntidad) {
		this.datosDeEntidad = datosDeEntidad;
	}
	public int getEmpresaContratante() {
		return empresaContratante;
	}
	public void setEmpresaContratante(int empresaContratante) {
		this.empresaContratante = empresaContratante;
	}
	public List<Empresa> getEmpresasEnSeguimiento() {
		return empresasEnSeguimiento;
	}
	public void setEmpresasEnSeguimiento(List<Empresa> empresasEnSeguimiento) {
		this.empresasEnSeguimiento = empresasEnSeguimiento;
	}
}
