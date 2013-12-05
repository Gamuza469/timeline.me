package timeline.persistence.relation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import timeline.model.relation.EmpresaAutorizaAgente;
import timeline.persistence.PersistenceException;
import timeline.persistence.conn.ConnectionProvider;

public class EmpresaAutorizaAgenteDaoImpl implements EmpresaAutorizaAgenteDao {
	private static EmpresaAutorizaAgenteDao instance = new EmpresaAutorizaAgenteDaoImpl();
	public static EmpresaAutorizaAgenteDao getInstance() {
		return instance;
	}
	
	@Override
	public List<EmpresaAutorizaAgente> findByEmpresaCuit(int cuit)
			throws PersistenceException {
		List<EmpresaAutorizaAgente> listaAgentes = new LinkedList<EmpresaAutorizaAgente>();
		try {
			String query = "SELECT * FROM autoriza_a WHERE cuitEmpresa = ?";
			PreparedStatement statement = ConnectionProvider.getInstance()
					.getConnection().prepareStatement(query);
			statement.setInt(1, cuit);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				listaAgentes.add(this.convertOne(resultSet));
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return listaAgentes;
	}

	private EmpresaAutorizaAgente convertOne (ResultSet resultSet) throws SQLException {
		EmpresaAutorizaAgente unItem = new EmpresaAutorizaAgente();
		
		unItem.setCuitAgente(resultSet.getInt("cuitAgente"));
		unItem.setCuitEmpresa(resultSet.getInt("cuitEmpresa"));
		
		return unItem;
	}
}
