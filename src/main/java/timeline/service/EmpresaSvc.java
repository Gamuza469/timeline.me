package timeline.service;

import java.util.LinkedList;
import java.util.List;

import timeline.model.Agente;
import timeline.model.Empresa;
import timeline.model.Entidad;
import timeline.model.Noticia;
import timeline.model.relation.EmpresaAutorizaAgente;
import timeline.persistence.AdjuntoDao;
import timeline.persistence.AgenteDao;
import timeline.persistence.DaoFactory;
import timeline.persistence.EmpresaDao;
import timeline.persistence.EntidadDao;
import timeline.persistence.NoticiaDao;
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
		AgenteDao agenteDao = DaoFactory.getAgenteDao();
		EntidadDao entidadDao = DaoFactory.getEntidadDao();
		NoticiaDao noticiaDao = DaoFactory.getNoticiaDao();
		AdjuntoDao adjuntoDao = DaoFactory.getAdjuntoDao();
		EmpresaAutorizaAgenteDao empresaAutorizaAgenteDao = DaoFactory.getEmpresaAutorizaAgenteDao();
		
		Empresa empresa = empresaDao.findByCuit(cuitEmpresa);
		Entidad entidad = entidadDao.findByCuit(cuitEmpresa);
		empresa.setDatosDeEntidad(entidad);
		
		List<Agente> listaAgentes = new LinkedList<Agente>();
		List<EmpresaAutorizaAgente> listaAgentesAutorizados = empresaAutorizaAgenteDao.findByEmpresaCuit(empresa.getDatosDeEntidad().getCuit());
		for (EmpresaAutorizaAgente item: listaAgentesAutorizados) {
			Agente agente = agenteDao.findByCuit(item.getCuitAgente());			
			agente.setDatosDeEntidad(entidadDao.findByCuit(item.getCuitAgente()));
			listaAgentes.add(agente);
		}		
		
		List<Noticia> listaNoticias = noticiaDao.findByCuit(cuitEmpresa);
		for (Noticia noticia: listaNoticias) {
			noticia.setListaAdjuntos(adjuntoDao.findByIdNoticia(noticia.getIdNoticia()));
		}
		
		empresa.setAgentesAutorizados(listaAgentes);
		empresa.setLineaDeTiempo(listaNoticias);
		
		return empresa;
	}
}
