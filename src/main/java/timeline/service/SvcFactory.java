package timeline.service;

import timeline.service.controller.EmpresaCtrlSvc;
import timeline.service.controller.EmpresasEnSeguimientoSvc;
import timeline.service.controller.ListaDeEmpresasSvc;
import timeline.service.controller.LoginSvc;
import timeline.service.controller.MostrarAgentesSvc;
import timeline.service.relation.AgenteSigueEmpresaSvc;
import timeline.service.relation.EmpresaAutorizaAgenteSvc;

public class SvcFactory {
	public static EmpresaSvc getEmpresaSvc () {
		return new EmpresaSvc();
	}

	public static AgenteSvc getAgenteSvc () {
		return new AgenteSvc();
	}
	
	public static EntidadSvc getEntidadSvc () {
		return new EntidadSvc();
	}
	
	public static NoticiaSvc getNoticiaSvc () {
		return new NoticiaSvc();
	}
	
	public static AdjuntoSvc getAdjuntoSvc () {
		return new AdjuntoSvc();
	}
	
	public static EmpresaAutorizaAgenteSvc getEmpresaAutorizaAgenteSvc () {
		return new EmpresaAutorizaAgenteSvc();
	}
	
	public static AgenteSigueEmpresaSvc getAgenteSigueEmpresaSvc () {
		return new AgenteSigueEmpresaSvc();
	}
	
	public static LoginSvc getLoginSvc () {
		return new LoginSvc();
	}
	
	public static MostrarAgentesSvc getMostrarAgentesSvc () {
		return new MostrarAgentesSvc();
	}
	
	public static EmpresasEnSeguimientoSvc getEmpresasEnSeguimientoSvc () {
		return new EmpresasEnSeguimientoSvc();
	}
	
	public static ListaDeEmpresasSvc getListaDeEmpresasSvc () {
		return new ListaDeEmpresasSvc();
	}
	
	public static EmpresaCtrlSvc getEmpresaCtrlSvc() {
		return new EmpresaCtrlSvc();
	}
}
