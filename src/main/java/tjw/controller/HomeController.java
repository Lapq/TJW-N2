package tjw.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import tjw.security.MyUserDetails;
import tjw.security.MyUserDetailsService;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "/home";
	}
	
	@GetMapping({"/login"})
	public String login() {
		return "login";
	}
	
	@GetMapping({"/login-error"})
	public String loginError(ModelMap model) {
		model.addAttribute("alerta", "erro");
		model.addAttribute("titulo", "Crendenciais inválidas!");
		model.addAttribute("texto", "Login ou senha incorretos, tente novamente.");
		model.addAttribute("subtexto", "Acesso permitido apenas para usuários cadastrados");
		return "/";
	}
	
	@ModelAttribute("user")
	public User getUser() {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null && auth.isAuthenticated() && !"anonymousUser".equals(auth.getPrincipal())) {
	        return (User) auth.getPrincipal();
	    }
	    return null;
	 }
}
