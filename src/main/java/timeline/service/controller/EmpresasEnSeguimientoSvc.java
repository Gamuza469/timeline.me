package timeline.service.controller;

import java.util.LinkedList;
import java.util.List;

import timeline.model.Empresa;
import timeline.model.Entidad;
import timeline.model.relation.AgenteSigueEmpresa;
import timeline.persistence.PersistenceException;
import timeline.service.EmpresaSvc;
import timeline.service.EntidadSvc;
import timeline.service.SvcFactory;
import timeline.service.relation.AgenteSigueEmpresaSvc;

public class EmpresasEnSeguimientoSvc {
	public List<Empresa> getEmpresasEnSeguimiento (int username) throws PersistenceException {
		AgenteSigueEmpresaSvc agenteSigueEmpresaSvc = SvcFactory.getAgenteSigueEmpresaSvc();
		EmpresaSvc empresaSvc = SvcFactory.getEmpresaSvc();
		EntidadSvc entidadSvc = SvcFactory.getEntidadSvc();
		
		List<Empresa> listaEmpresas = new LinkedList<Empresa>();
		List<AgenteSigueEmpresa> listaAgentes = agenteSigueEmpresaSvc.findByAgenteCuit(username);
		for (AgenteSigueEmpresa item: listaAgentes) {
			Empresa empresa = empresaSvc.findByCuit(item.getCuitEmpresa());
			Entidad entidad = entidadSvc.findByCuit(item.getCuitEmpresa());
			empresa.setDatosDeEntidad(entidad);
			listaEmpresas.add(empresa);
		}
		
		return listaEmpresas;
	}
}
