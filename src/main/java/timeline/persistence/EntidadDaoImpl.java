package timeline.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import timeline.model.Entidad;
import timeline.persistence.conn.ConnectionProvider;

public class EntidadDaoImpl implements EntidadDao {
	private static EntidadDao instance = new EntidadDaoImpl();
	public static EntidadDao getInstance() {
		return instance;
	}
	@Override
	public Entidad findByCuit(String cuit) throws PersistenceException {
		Entidad entidad = new Entidad();
		try {
			String query = "SELECT * FROM entidad WHERE cuit = ?";
			PreparedStatement statement = ConnectionProvider.getInstance()
					.getConnection().prepareStatement(query);
			statement.setString(1, cuit);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				entidad = this.convertOne(resultSet);
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return entidad;
	}
	
	private Entidad convertOne (ResultSet resultSet) throws SQLException {
		Entidad unaEntidad = new Entidad();
		
		unaEntidad.setCuit(resultSet.getInt("cuit"));
		unaEntidad.setDomicilio(resultSet.getString("domicilio"));
		unaEntidad.setEmail(resultSet.getString("email"));
		unaEntidad.setPassword(resultSet.getString("password"));
		unaEntidad.setTelefono(resultSet.getString("telefono"));
		
		return unaEntidad;
	}
}
