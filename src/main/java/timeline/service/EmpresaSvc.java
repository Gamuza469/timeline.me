package timeline.service;

import java.util.List;

import timeline.model.Empresa;
import timeline.model.Noticia;
import timeline.persistence.DaoFactory;
import timeline.persistence.EmpresaDao;

public class EmpresaSvc {
	public Empresa getEmpresa (String cuitEmpresa) {
		EmpresaDao empresaDao = DaoFactory.getEmpresaDao();
		NoticiaDao noticiaDao = DaoFactory.getNoticiaDao();
		AdjuntoDao adjuntoDao = DaoFactory.getAdjuntoDao();
		
		Empresa empresa = empresaDao.findByCuit(cuitEmpresa);
		List<Noticia> listaNoticias = noticiaDao.findByCuit(cuitEmpresa);
		
		for (Noticia noti: listaNoticias) {
			noti.setListaAdjuntos(adjuntoDao.findByIdNoticia(noti.getIdNoticia()));
		}
		
		empresa.setLineaDeTiempo(listaNoticias);
		
		return empresa;
	}
}
