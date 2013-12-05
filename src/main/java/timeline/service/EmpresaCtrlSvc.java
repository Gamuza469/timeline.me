package timeline.service;

import timeline.model.Empresa;

public class EmpresaCtrlSvc {
	public Empresa getEmpresa (String cuitEmpresa) {
		EmpresaSvc empresaSvc = SvcFactory.getEmpresaSvc();
		return empresaSvc.getEmpresa(cuitEmpresa);
	}
}
