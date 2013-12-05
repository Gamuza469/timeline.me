package timeline.service;

import java.util.List;

import timeline.model.Empresa;

public class EmpresasEnSeguimientoSvc {
	public List<Empresa> getEmpresasEnSeguimiento (String username) {
		EmpresaDaoImpl empresaDao = DaoFactory.getEmpresaDao();
		List<Empresa> listaEmpresas = empresaDao.findEmpresasEnSeguimientoByCuit(username);
		
		return listaEmpresas;
	}
}
