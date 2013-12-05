package timeline.service.controller;

import java.util.List;

import timeline.model.Empresa;
import timeline.persistence.PersistenceException;
import timeline.service.EmpresaSvc;
import timeline.service.SvcFactory;

public class ListaDeEmpresasSvc {
	public List<Empresa> getTodasLasEmpresas() throws PersistenceException {
		EmpresaSvc empresaSvc = SvcFactory.getEmpresaSvc();
		List<Empresa> listaEmpresas = empresaSvc.findAll();
		
		return listaEmpresas;
	}
}
