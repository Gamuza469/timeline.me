package timeline.persistence;

import java.util.List;

import timeline.model.Noticia;

public interface NoticiaDao {
	public List<Noticia> findByCuit (String cuitEmpresa) throws PersistenceException;
}
