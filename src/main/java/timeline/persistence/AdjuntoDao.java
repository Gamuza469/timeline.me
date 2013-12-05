package timeline.persistence;

import java.sql.Blob;
import java.util.List;

public interface AdjuntoDao {
	public List<Blob> findByIdNoticia (int idNoticia) throws PersistenceException;
}
