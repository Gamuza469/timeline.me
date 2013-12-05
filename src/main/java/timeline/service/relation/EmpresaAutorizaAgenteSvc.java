package timeline.service.relation;

import java.util.List;

import timeline.model.relation.EmpresaAutorizaAgente;
import timeline.persistence.DaoFactory;
import timeline.persistence.PersistenceException;
import timeline.persistence.relation.EmpresaAutorizaAgenteDao;

public class EmpresaAutorizaAgenteSvc {
	public List<EmpresaAutorizaAgente> findByEmpresaCuit (int cuit) throws PersistenceException {
		EmpresaAutorizaAgenteDao empresaAutorizaAgenteDao = DaoFactory.getEmpresaAutorizaAgenteDao();
		return empresaAutorizaAgenteDao.findByEmpresaCuit(cuit);
	}
}
