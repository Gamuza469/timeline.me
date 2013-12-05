package timeline.service;

import java.util.List;

import timeline.model.Agente;

public class MostrarAgentesSvc {
	public List<Agente> getAgentesEmpresa (String username) {
		AgenteDao agenteDao = DaoFactory.getAgendeDao();
		List<Agente> listaAgentes = agenteDao.findByEmpresa(username); 
		
		return listaAgentes;
	}
}
