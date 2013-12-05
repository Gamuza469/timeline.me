package timeline.persistence;

import timeline.model.Entidad;

public interface EntidadDao {
	public Entidad findByCuit (String cuit) throws PersistenceException;
}
