package timeline.service;

import java.util.List;

import timeline.model.Noticia;

public class LineaDeTiempoSvc {
	public List<Noticia> getLineaDeTiempoEmpresa (String username) {
		NoticiaDao noticiaDao = DaoFactory.getNoticiaDao();
		return noticiaDao.findByCuit(username);
	}
	
	public void guardarNoticia (String noticia, String encabezado, String username) {
		NoticiaDao noticiaDao = DaoFactory.getNoticiaDao();
		noticiaDao.insert(noticia, encabezado, username);	
	}
}
