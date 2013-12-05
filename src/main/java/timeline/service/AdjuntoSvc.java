package timeline.service;

import java.sql.Blob;
import java.util.List;

import timeline.persistence.AdjuntoDao;
import timeline.persistence.DaoFactory;
import timeline.persistence.PersistenceException;

public class AdjuntoSvc {

	public List<Blob> findByIdNoticia(int idNoticia) throws PersistenceException {
		AdjuntoDao adjuntoDao = DaoFactory.getAdjuntoDao();
		return adjuntoDao.findByIdNoticia(idNoticia);
	}

}
