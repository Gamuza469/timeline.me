package timeline.persistence;

import java.util.List;

import timeline.model.Empresa;

public interface EmpresaDao {
	public Empresa findByCuit (String cuitEmpresa) throws PersistenceException;
	public List<Empresa> findAll () throws PersistenceException;
}
