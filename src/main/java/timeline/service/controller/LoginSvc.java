package timeline.service.controller;

import timeline.model.Agente;
import timeline.model.Entidad;
import timeline.persistence.AgenteDao;
import timeline.persistence.DaoFactory;
import timeline.persistence.EntidadDao;
import timeline.persistence.PersistenceException;

public class LoginSvc {
	public boolean autenticarUsuario (int username, String password) throws PersistenceException {
		EntidadDao entidadDao = DaoFactory.getEntidadDao();
		Entidad entidad = entidadDao.findByCuit(username);
		
		if (entidad.getPassword() == password)
			return true;
		else
			return false;
	}
	
	public boolean confirmaAgente (int username) throws PersistenceException {
		AgenteDao agenteDao = DaoFactory.getAgenteDao();
		Agente agente = agenteDao.findByCuit(username);
		
		if (agente != null)
			return true;
		else
			return false;
	}
}
