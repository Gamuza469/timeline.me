package timeline.model;

import java.util.List;

public class Empresa {
	private String razonSocial;
	private Entidad datosDeEntidad;
	private List<Noticia> lineaDeTiempo;
	private List<Agente> agentesAutorizados;
	
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public Entidad getDatosDeEntidad() {
		return datosDeEntidad;
	}
	public void setDatosDeEntidad(Entidad datosDeEntidad) {
		this.datosDeEntidad = datosDeEntidad;
	}
	public List<Noticia> getLineaDeTiempo() {
		return lineaDeTiempo;
	}
	public void setLineaDeTiempo(List<Noticia> lineaDeTiempo) {
		this.lineaDeTiempo = lineaDeTiempo;
	}
	public List<Agente> getAgentesAutorizados() {
		return agentesAutorizados;
	}
	public void setAgentesAutorizados(List<Agente> agentesAutorizados) {
		this.agentesAutorizados = agentesAutorizados;
	}
}
