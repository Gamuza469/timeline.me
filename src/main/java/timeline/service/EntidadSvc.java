package timeline.service;

import timeline.model.Entidad;
import timeline.persistence.DaoFactory;
import timeline.persistence.EntidadDao;
import timeline.persistence.PersistenceException;

public class EntidadSvc {
	public Entidad findByCuit (int cuit) throws PersistenceException {
		EntidadDao entidadDao = DaoFactory.getEntidadDao();
		return entidadDao.findByCuit(cuit);
	}
}
