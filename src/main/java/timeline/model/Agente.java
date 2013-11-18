package timeline.model;

import java.util.List;

public class Agente {
	private String nombreCompleto;
	private DatosDeContacto datosDeContacto;
	private List<Empresa> empresasEnSeguimiento;
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public DatosDeContacto getDatosDeContacto() {
		return datosDeContacto;
	}
	public void setDatosDeContacto(DatosDeContacto datosDeContacto) {
		this.datosDeContacto = datosDeContacto;
	}
	public List<Empresa> getEmpresasEnSeguimiento() {
		return empresasEnSeguimiento;
	}
	public void setEmpresasEnSeguimiento(List<Empresa> empresasEnSeguimiento) {
		this.empresasEnSeguimiento = empresasEnSeguimiento;
	}
}
