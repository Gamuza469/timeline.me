package timeline.persistence.relation;

import java.util.List;

import timeline.model.relation.AgenteSigueEmpresa;
import timeline.persistence.PersistenceException;

public interface AgenteSigueEmpresaDao {
	public List<AgenteSigueEmpresa> findByAgenteCuit (int cuit) throws PersistenceException; 
}
