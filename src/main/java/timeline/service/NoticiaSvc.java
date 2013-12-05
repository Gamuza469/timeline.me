package timeline.service;

import java.util.List;

import timeline.model.Noticia;
import timeline.persistence.DaoFactory;
import timeline.persistence.NoticiaDao;
import timeline.persistence.PersistenceException;

public class NoticiaSvc {

	public List<Noticia> findByCuit(String cuitEmpresa) throws PersistenceException {
		NoticiaDao noticiaDao = DaoFactory.getNoticiaDao();
		return noticiaDao.findByCuit(cuitEmpresa);
	}

}
