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
import timeline.service.ListaDeEmpresasSvc;
import timeline.service.SvcFactory;

@Controller
@SessionAttributes({"username", "tipoUsuario"})
public class ListaDeEmpresasCtrl {
	
	ListaDeEmpresasSvc listaDeEmpresasSvc = SvcFactory.getListaDeEmpresasSvc();

		@RequestMapping(value="/listaEmpresas", method=RequestMethod.GET)
		public ModelAndView getListaEmpresas
			(HttpServletRequest request, HttpSession session) 
				throws PersistenceException	
		{
			ModelAndView mav = new ModelAndView();
			String username = (String) request.getAttribute("username");
			String tipoUsuario = (String) request.getAttribute("tipoUsuario");
			
			List<Empresa> listaEmpresas = listaDeEmpresasSvc.getTodasLasEmpresas();
			
			mav.addObject("listaEmpresas", listaEmpresas);
			mav.addObject("username", username);
			mav.addObject("tipoUsuario", tipoUsuario);
			mav.setViewName("listaEmpresas");
			
			return mav;
		}
}
