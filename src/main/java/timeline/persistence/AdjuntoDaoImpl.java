package timeline.persistence;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AdjuntoDaoImpl implements AdjuntoDao {
	private static AdjuntoDao instance = new AdjuntoDaoImpl();
	public static AdjuntoDao getInstance() {
		return instance;
	}
	
	@Override
	public List<Blob> findByIdNoticia(int idNoticia)
			throws PersistenceException {
		List<Blob> listaAdjuntos = new LinkedList<Blob>();
		try {
			String query = "SELECT * FROM archivo_adjunto WHERE idNoticia = ?";
			PreparedStatement statement = ConnectionProvider.getInstance()
					.getConnection().prepareStatement(query);
			statement.setInt(1, idNoticia);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				listaAdjuntos.add(resultSet.getBlob("adjunto"));
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return listaAdjuntos;
	}
}
