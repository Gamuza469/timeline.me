package timeline.service;

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
	
	public static LoginSvc getLoginSvc () {
		return new LoginSvc();
	}
	
	public static LineaDeTiempoSvc getLineaDeTiempoSvc () {
		return new LineaDeTiempoSvc();
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
