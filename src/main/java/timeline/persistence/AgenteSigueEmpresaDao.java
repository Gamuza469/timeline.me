package timeline.persistence;

import java.util.List;

import timeline.model.AgenteSigueEmpresa;

public interface AgenteSigueEmpresaDao {
	public List<AgenteSigueEmpresa> findByAgenteCuit (int cuit) throws PersistenceException; 
}
