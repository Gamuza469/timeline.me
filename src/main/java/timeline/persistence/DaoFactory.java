package timeline.persistence;

import timeline.persistence.relation.AgenteSigueEmpresaDao;
import timeline.persistence.relation.AgenteSigueEmpresaDaoImpl;
import timeline.persistence.relation.EmpresaAutorizaAgenteDao;
import timeline.persistence.relation.EmpresaAutorizaAgenteDaoImpl;

public class DaoFactory {

	public static EmpresaDao getEmpresaDao(){
		return EmpresaDaoImpl.getInstance();
	}
	
	public static AgenteDao getAgenteDao(){
		return AgenteDaoImpl.getInstance();
	}
	
	public static EntidadDao getEntidadDao(){
		return EntidadDaoImpl.getInstance();
	}
	
	public static NoticiaDao getNoticiaDao(){
		return NoticiaDaoImpl.getInstance();
	}
	
	public static AdjuntoDao getAdjuntoDao(){
		return AdjuntoDaoImpl.getInstance();
	}
	
	public static AgenteSigueEmpresaDao getAgenteSigueEmpresaDao(){
		return AgenteSigueEmpresaDaoImpl.getInstance();
	}
	
	public static EmpresaAutorizaAgenteDao getEmpresaAutorizaAgenteDao(){
		return EmpresaAutorizaAgenteDaoImpl.getInstance();
	}

}
