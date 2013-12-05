package timeline.persistence;

import timeline.model.Agente;

public interface AgenteDao {
	public Agente findByCuit (int cuit) throws PersistenceException;
}
