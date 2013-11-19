package timeline.model;

import java.io.File;
import java.util.Date;
import java.util.List;

public class Noticia {
	private int idNoticia;
	private String encabezado;
	private String contenido;
	private Date fechaCreacion;
	private List<File> listaAdjuntos;
	
	public int getIdNoticia() {
		return idNoticia;
	}
	public void setIdNoticia(int idNoticia) {
		this.idNoticia = idNoticia;
	}
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
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public List<File> getListaAdjuntos() {
		return listaAdjuntos;
	}
	public void setListaAdjuntos(List<File> listaAdjuntos) {
		this.listaAdjuntos = listaAdjuntos;
	}
}
