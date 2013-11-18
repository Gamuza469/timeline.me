package timeline.model;

import java.util.List;

public class Agente {
	private String nombreCompleto;
	private Entidad datosDeEntidad;
	private int empresaContratante;
	private List<Empresa> empresasEnSeguimiento;
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
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
