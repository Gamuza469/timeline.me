package timeline.service.controller;

import timeline.model.Empresa;
import timeline.persistence.PersistenceException;
import timeline.service.EmpresaSvc;
import timeline.service.SvcFactory;

public class EmpresaCtrlSvc {
	public Empresa getEmpresa (int cuitEmpresa) throws PersistenceException {
		EmpresaSvc empresaSvc = SvcFactory.getEmpresaSvc();
		return empresaSvc.getEmpresa(cuitEmpresa);
	}
}
