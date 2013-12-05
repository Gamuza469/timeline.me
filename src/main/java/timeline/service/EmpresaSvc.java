package timeline.service;

import java.util.LinkedList;
import java.util.List;

import timeline.model.Agente;
import timeline.model.Empresa;
import timeline.model.Entidad;
import timeline.model.Noticia;
import timeline.model.relation.EmpresaAutorizaAgente;
import timeline.persistence.DaoFactory;
import timeline.persistence.EmpresaDao;
import timeline.persistence.PersistenceException;
import timeline.persistence.relation.EmpresaAutorizaAgenteDao;

public class EmpresaSvc {
	
	public Empresa findByCuit (int cuit) throws PersistenceException {
		EmpresaDao empresaDao = DaoFactory.getEmpresaDao();
		return empresaDao.findByCuit(cuit);
	}
	public List<Empresa> findAll () throws PersistenceException {
		EmpresaDao empresaDao = DaoFactory.getEmpresaDao();
		return empresaDao.findAll();
	}
	
	public Empresa getEmpresa (int cuitEmpresa) throws PersistenceException {
		EmpresaDao empresaDao = DaoFactory.getEmpresaDao();
		AgenteSvc agenteSvc = SvcFactory.getAgenteSvc();
		EntidadSvc entidadSvc = SvcFactory.getEntidadSvc();
		NoticiaSvc noticiaSvc = SvcFactory.getNoticiaSvc();
		AdjuntoSvc adjuntoSvc = SvcFactory.getAdjuntoSvc();
		EmpresaAutorizaAgenteDao empresaAutorizaAgenteDao = DaoFactory.getEmpresaAutorizaAgenteDao();
		
		Empresa empresa = empresaDao.findByCuit(cuitEmpresa);
		Entidad entidad = entidadSvc.findByCuit(cuitEmpresa);
		empresa.setDatosDeEntidad(entidad);
		
		List<Agente> listaAgentes = new LinkedList<Agente>();
		List<EmpresaAutorizaAgente> listaAgentesAutorizados = empresaAutorizaAgenteDao.findByEmpresaCuit(empresa.getDatosDeEntidad().getCuit());
		for (EmpresaAutorizaAgente item: listaAgentesAutorizados) {
			Agente agente = agenteSvc.findByCuit(item.getCuitAgente());			
			agente.setDatosDeEntidad(entidadSvc.findByCuit(item.getCuitAgente()));
			listaAgentes.add(agente);
		}		
		
		List<Noticia> listaNoticias = noticiaSvc.findByCuit(cuitEmpresa);
		for (Noticia noticia: listaNoticias) {
			noticia.setListaAdjuntos(adjuntoSvc.findByIdNoticia(noticia.getIdNoticia()));
		}
		
		empresa.setAgentesAutorizados(listaAgentes);
		empresa.setLineaDeTiempo(listaNoticias);
		
		return empresa;
	}
}
