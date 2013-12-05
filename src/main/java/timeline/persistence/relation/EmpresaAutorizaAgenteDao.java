package timeline.persistence.relation;

import java.util.List;

import timeline.model.relation.EmpresaAutorizaAgente;
import timeline.persistence.PersistenceException;

public interface EmpresaAutorizaAgenteDao {
	public List<EmpresaAutorizaAgente> findByEmpresaCuit (int cuit) throws PersistenceException;
}
