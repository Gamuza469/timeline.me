package timeline.service.relation;

import java.util.List;

import timeline.model.relation.AgenteSigueEmpresa;
import timeline.persistence.DaoFactory;
import timeline.persistence.PersistenceException;
import timeline.persistence.relation.AgenteSigueEmpresaDao;

public class AgenteSigueEmpresaSvc {
	public List<AgenteSigueEmpresa> findByAgenteCuit (int cuit) throws PersistenceException {
		AgenteSigueEmpresaDao agenteSigueEmpresaDao = DaoFactory.getAgenteSigueEmpresaDao();
		return agenteSigueEmpresaDao.findByAgenteCuit(cuit);
	}
}
