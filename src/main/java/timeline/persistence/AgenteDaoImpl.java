package timeline.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import timeline.model.Agente;
import timeline.persistence.conn.ConnectionProvider;

public class AgenteDaoImpl implements AgenteDao {
	private static AgenteDao instance = new AgenteDaoImpl();
	public static AgenteDao getInstance() {
		return instance;
	}
	@Override
	public Agente findByCuit(int cuit) throws PersistenceException {
		Agente agente = new Agente();
		try {
			String query = "SELECT * FROM agente WHERE cuit = ?";
			PreparedStatement statement = ConnectionProvider.getInstance()
					.getConnection().prepareStatement(query);
			statement.setInt(1, cuit);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				agente = this.convertOne(resultSet);
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return agente;
	}
	
	private Agente convertOne (ResultSet resultSet) throws SQLException {
		Agente unAgente = new Agente();
		
		unAgente.setApellido(resultSet.getString("apellido"));
		unAgente.setEmpresaContratante(resultSet.getInt("empresaContratante"));
		unAgente.setNombre(resultSet.getString("nombre"));
		
		return unAgente;
		
	} 
}
