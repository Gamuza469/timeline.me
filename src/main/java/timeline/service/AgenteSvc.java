package timeline.service;

import timeline.model.Agente;
import timeline.persistence.AgenteDao;
import timeline.persistence.DaoFactory;
import timeline.persistence.PersistenceException;

public class AgenteSvc {
	public Agente findByCuit (int cuit) throws PersistenceException {
		AgenteDao agenteDao = DaoFactory.getAgenteDao();
		return agenteDao.findByCuit(cuit);
	}
}
