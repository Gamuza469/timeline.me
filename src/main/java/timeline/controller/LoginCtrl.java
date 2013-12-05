package timeline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import timeline.persistence.PersistenceException;
import timeline.service.LoginSvc;
import timeline.service.SvcFactory;

@SessionAttributes({"username", "tipoUsuario"})
@Controller
public class LoginCtrl {

	LoginSvc loginSvc = SvcFactory.getLoginSvc();
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView postAutenticarUsuario 
		(HttpServletRequest request, HttpSession session) 
				throws PersistenceException
	{
		ModelAndView mav = new ModelAndView();
		String username = (String) request.getAttribute("username");
		String password = (String) request.getAttribute("password");
		boolean usuarioConfirmado = loginSvc.autenticarUsuario(username, password);
		boolean esUsuarioAgente = loginSvc.confirmaAgente(username);
		
		if (usuarioConfirmado == true) {
			mav.addObject("username", username);
			mav.setViewName("lineaDeTiempo");
			if (esUsuarioAgente == true)
				mav.addObject("tipoUsuario", "agente");
			else
				mav.addObject("tipoUsuario", "empresa");
		} else {
			mav.addObject("error", "Usuario no válido.");
			mav.setViewName("login");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public ModelAndView getDisconnect
		(HttpServletRequest request, HttpSession session, SessionStatus status) 
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", null);
		mav.setViewName("login");
		status.setComplete();
		
		return mav;
	}
	
}
