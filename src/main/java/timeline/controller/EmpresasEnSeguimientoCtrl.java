package timeline.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import timeline.model.Empresa;
import timeline.persistence.PersistenceException;
import timeline.service.SvcFactory;
import timeline.service.controller.EmpresasEnSeguimientoSvc;

@Controller
@SessionAttributes({"username", "tipoUsuario"})
public class EmpresasEnSeguimientoCtrl {
	
	EmpresasEnSeguimientoSvc empresasEnSeguimientoSvc = SvcFactory.getEmpresasEnSeguimientoSvc();

	@RequestMapping(value="/empSegui", method=RequestMethod.GET)
	public ModelAndView getEmpresasEnSeguimiento
		(HttpServletRequest request, HttpSession session) 
			throws PersistenceException	
	{
		ModelAndView mav = new ModelAndView();
		int username = (int) request.getAttribute("username");
		String tipoUsuario = (String) request.getAttribute("tipoUsuario");
		
		List<Empresa> listaEmpresas = empresasEnSeguimientoSvc.getEmpresasEnSeguimiento(username);
		
		mav.addObject("username", username);
		mav.addObject("tipoUsuario", tipoUsuario);
		mav.addObject("listaEmpresas", listaEmpresas);
		mav.setViewName("empSegui");
		
		return mav;
	}
	
}
