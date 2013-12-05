package timeline.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import timeline.model.Agente;
import timeline.persistence.PersistenceException;
import timeline.service.SvcFactory;
import timeline.service.controller.MostrarAgentesSvc;

@Controller
@SessionAttributes({"username", "tipoUsuario"})
public class MostrarAgentesCtrl {
	
	MostrarAgentesSvc mostrarAgentesSvc = SvcFactory.getMostrarAgentesSvc();

	@RequestMapping(value="/listarAgentes", method=RequestMethod.GET)
	public ModelAndView getListarAgentes
		(HttpServletRequest request, HttpSession session) 
			throws PersistenceException
	{
		ModelAndView mav = new ModelAndView();
		int username = (int) request.getAttribute("username");
		String tipoUsuario = (String) request.getAttribute("tipoUsuario");
		
		List<Agente> listaAgentes = mostrarAgentesSvc.getAgentesEmpresa(username);
		mav.addObject("listaAgentes", listaAgentes);
		mav.addObject("username", username);
		mav.addObject("tipoUsuario", tipoUsuario);
		mav.setViewName("listaAgentes");
		
		return mav;
	}
}
