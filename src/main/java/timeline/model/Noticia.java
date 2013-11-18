package timeline.model;

import java.io.File;
import java.util.List;

public class Noticia {
	private String encabezado;
	private String contenido;
	private List<File> listaAdjuntos;
	
	public String getEncabezado() {
		return encabezado;
	}
	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public List<File> getListaAdjuntos() {
		return listaAdjuntos;
	}
	public void setListaAdjuntos(List<File> listaAdjuntos) {
		this.listaAdjuntos = listaAdjuntos;
	}
}
