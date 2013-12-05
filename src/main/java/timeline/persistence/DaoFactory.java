package timeline.persistence;

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

}
