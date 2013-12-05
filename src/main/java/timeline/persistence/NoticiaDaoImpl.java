package timeline.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import timeline.model.Noticia;
import timeline.persistence.conn.ConnectionProvider;

public class NoticiaDaoImpl implements NoticiaDao {
	private static NoticiaDao instance = new NoticiaDaoImpl();
	public static NoticiaDao getInstance() {
		return instance;
	}
	@Override
	public List<Noticia> findByCuit(int cuit) throws PersistenceException {
		List<Noticia> listaNoticias = new LinkedList<Noticia>();
		try {
			String query = "SELECT * FROM noticia WHERE cuit = ?";
			PreparedStatement statement = ConnectionProvider.getInstance()
					.getConnection().prepareStatement(query);
			statement.setInt(1, cuit);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				listaNoticias.add(this.convertOne(resultSet));
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return listaNoticias;
	}

	private Noticia convertOne (ResultSet resultSet) throws SQLException {
		Noticia unaNoticia = new Noticia();
		
		unaNoticia.setContenido(resultSet.getString("contenido"));
		unaNoticia.setEncabezado(resultSet.getString("encabezado"));
		unaNoticia.setFechaCreacion(resultSet.getDate("fechaCreacion"));
		unaNoticia.setIdNoticia(resultSet.getInt("idNoticia"));
		
		return unaNoticia;
		
	}
}
