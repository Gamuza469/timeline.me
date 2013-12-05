package timeline.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import timeline.model.Empresa;
import timeline.persistence.conn.ConnectionProvider;


public class EmpresaDaoImpl implements EmpresaDao {
	private static EmpresaDao instance = new EmpresaDaoImpl();
	public static EmpresaDao getInstance() {
		return instance;
	}

	@Override
	public Empresa findByCuit(int cuit) throws PersistenceException {
		Empresa empresa = new Empresa();
		try {
			String query = "SELECT * FROM empresa WHERE cuit = ?";
			PreparedStatement statement = ConnectionProvider.getInstance()
					.getConnection().prepareStatement(query);
			statement.setInt(1, cuit);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				empresa = this.convertOne(resultSet);
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return empresa;
	}

	@Override
	public List<Empresa> findAll() throws PersistenceException {
		List<Empresa> listaEmpresa = new LinkedList<Empresa>();
		try {
			String query = "SELECT * FROM empresa";
			PreparedStatement statement = ConnectionProvider.getInstance()
					.getConnection().prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				listaEmpresa.add(this.convertOne(resultSet));
			}
		} catch (SQLException sqlException) {
			throw new PersistenceException(sqlException);
		}
		return listaEmpresa;
	}
	
	private Empresa convertOne (ResultSet resultSet) throws SQLException {
		Empresa unaEmpresa = new Empresa();
		unaEmpresa.setRazonSocial(resultSet.getString("razonSocial"));
		return unaEmpresa;
	}
	
	
	
}
