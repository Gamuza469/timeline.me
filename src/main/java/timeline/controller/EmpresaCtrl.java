package timeline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import timeline.model.Empresa;
import timeline.persistence.PersistenceException;
import timeline.service.EmpresaCtrlSvc;
import timeline.service.SvcFactory;

@SessionAttributes({"username", "tipoUsuario"})
@Controller
public class EmpresaCtrl {
	
	EmpresaCtrlSvc empresaCtrlSvc = SvcFactory.getEmpresaCtrlSvc();
	
	@RequestMapping(value="/empresa", method=RequestMethod.GET)
	public ModelAndView getEmpresa
		(HttpServletRequest request, HttpSession session) 
			throws PersistenceException	
	{
		ModelAndView mav = new ModelAndView();
		String username = (String) request.getAttribute("username");
		String tipoUsuario = (String) request.getAttribute("tipoUsuario");
		String cuitEmpresa = (String) request.getAttribute("cuitEmpresa");
		
		Empresa empresa = empresaCtrlSvc.getEmpresa(cuitEmpresa);
		mav.addObject("empresa", empresa);
		mav.addObject("username", username);
		mav.addObject("tipoUsuario", tipoUsuario);
		mav.setViewName("empresa");
		
		return mav;
		
	}
	

}