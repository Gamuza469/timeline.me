package timeline.persistence.relation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import timeline.model.relation.AgenteSigueEmpresa;
import timeline.persistence.PersistenceException;
import timeline.persistence.conn.ConnectionProvider;

public class AgenteSigueEmpresaDaoImpl implements AgenteSigueEmpresaDao {
	private static AgenteSigueEmpresaDao instance = new AgenteSigueEmpresaDaoImpl();
	public static AgenteSigueEmpresaDao getInstance() {
		return instance;
	}
	
	@Override
	public List<AgenteSigueEmpresa> findByAgenteCuit(int cuit) throws PersistenceException {
		List<AgenteSigueEmpresa> listaEmpresas = new LinkedList<AgenteSigueEmpresa>();
		try {
			String query = "SELECT * FROM sigue_a WHERE cuitAgente = ?";
			PreparedStatement statement = ConnectionProvider.getInstance()
					.getConnection().prepareStatement(query);
			statement.setInt(1, cuit);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				listaEmpresas.add(this.convertOne(resultSet));
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return listaEmpresas;
	}
	
	private AgenteSigueEmpresa convertOne (ResultSet resultSet) throws SQLException {
		AgenteSigueEmpresa unItem = new AgenteSigueEmpresa();
		
		unItem.setCuitAgente(resultSet.getInt("cuitAgente"));
		unItem.setCuitEmpresa(resultSet.getInt("cuitEmpresa"));
		
		return unItem;
	}
}
