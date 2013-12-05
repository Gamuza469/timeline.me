package timeline.service;

import java.util.List;

import timeline.model.Empresa;

public class ListaDeEmpresasSvc {
	public List<Empresa> getTodasLasEmpresas() {
		EmpresaDaoImpl empresaDao = DaoFactory.getEmpresaDao();
		List<Empresa> listaEmpresas = empresaDao.findAll();
		
		return listaEmpresas;
	}
}
