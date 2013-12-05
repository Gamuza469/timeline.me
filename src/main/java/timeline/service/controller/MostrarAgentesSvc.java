package timeline.service.controller;

import java.util.LinkedList;
import java.util.List;

import timeline.model.Agente;
import timeline.model.Entidad;
import timeline.model.relation.EmpresaAutorizaAgente;
import timeline.persistence.PersistenceException;
import timeline.service.AgenteSvc;
import timeline.service.EntidadSvc;
import timeline.service.SvcFactory;
import timeline.service.relation.EmpresaAutorizaAgenteSvc;

public class MostrarAgentesSvc {
	public List<Agente> getAgentesEmpresa (int username) throws PersistenceException {
		EmpresaAutorizaAgenteSvc empresaAutorizaAgenteSvc = SvcFactory.getEmpresaAutorizaAgenteSvc();
		AgenteSvc agenteSvc = SvcFactory.getAgenteSvc();
		EntidadSvc entidadSvc = SvcFactory.getEntidadSvc();
		
		Agente agente = agenteSvc.findByCuit(username);
		List<Agente> listaAgentes = new LinkedList<Agente>();
		List<EmpresaAutorizaAgente> listaAgentesAutorizados = empresaAutorizaAgenteSvc.findByEmpresaCuit(agente.getEmpresaContratante());
		
		for (EmpresaAutorizaAgente item: listaAgentesAutorizados) {
			Agente agente2 = agenteSvc.findByCuit(item.getCuitAgente());
			Entidad entidad = entidadSvc.findByCuit(item.getCuitAgente());
			agente2.setDatosDeEntidad(entidad);
			listaAgentes.add(agente2);
		}
		
		return listaAgentes;
	}
}
