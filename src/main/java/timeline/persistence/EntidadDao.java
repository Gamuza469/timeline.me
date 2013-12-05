package timeline.persistence;

import timeline.model.Entidad;

public interface EntidadDao {
	public Entidad findByCuit (int cuit) throws PersistenceException;
}
