package timeline.service;

public class LoginSvc {
	public boolean autenticarUsuario (String username, String password) {
		EntidadDao entidadDao = DaoFactory.getEntidadDao();
		Entidad entidad = entidadDao.findByCuit(username);
		
		if (entidad.getPassword() == password)
			return true;
		else
			return false;
	}
	
	public boolean confirmaAgente (String username) {
		AgenteDao agenteDao = DaoFactory.getAgenteDao();
		Agente agente = agenteDao.findByCuit(username);
		
		if (agente != null)
			return true;
		else
			return false;
	}
}
