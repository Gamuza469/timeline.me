package timeline.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import timeline.model.Noticia;
import timeline.persistence.PersistenceException;
import timeline.service.LineaDeTiempoSvc;
import timeline.service.SvcFactory;

@SessionAttributes({"username", "tipoUsuario", "noticiaGuardada"})
@Controller
public class LineaDeTiempoCtrl {
	
	LineaDeTiempoSvc lineaDeTiempoSvc = SvcFactory.getLineaDeTiempoSvc();

//	@RequestMapping(value="/linea", method=RequestMethod.GET)
//	public ModelAndView getLineaDeTiempo
//		(HttpServletRequest request, HttpSession session) 
//			throws PersistenceException
//	{
//		ModelAndView mav = new ModelAndView();
//		String username = (String) request.getAttribute("username");
//		String tipoUsuario = (String) request.getAttribute("tipoUsuario");
//		String noticiaGuardada = (String) request.getAttribute("noticiaGuardada");
//		
//		List<Noticia> lineaDeTiempo = lineaDeTiempoSvc.getLineaDeTiempoEmpresa(username);
//		mav.addObject("lineaDeTiempo", lineaDeTiempo);
//		mav.addObject("username", username);
//		mav.addObject("tipoUsuario", tipoUsuario);
//		mav.addObject("noticiaGuardada", noticiaGuardada);
//		mav.setViewName("linea");
//		
//		return mav;
//	}
	
	@RequestMapping (value="/agregarNoticia.do", method=RequestMethod.POST)
	public ModelAndView postNuevaNoticia 
		(HttpServletRequest request, HttpSession session) 
			throws PersistenceException
	{
		ModelAndView mav = new ModelAndView();
		String encabezado = (String) request.getAttribute("encabezado");
		String noticia = (String) request.getAttribute("noticia");
		String username = (String) request.getAttribute("username");
		String tipoUsuario = (String) request.getAttribute("tipoUsuario");
		
		lineaDeTiempoSvc.guardarNoticia(noticia, encabezado, username);
		
		mav.addObject("username", username);
		mav.addObject("tipoUsuario", tipoUsuario);
		mav.addObject("noticiaGuardad", "Noticia guardada");
		mav.setViewName("linea");
		
		return mav;
	}
	
}
