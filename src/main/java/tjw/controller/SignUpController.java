package tjw.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import tjw.model.Usuario;
import tjw.service.UsuarioServiceImpl;
import tjw.model.SignUp;

@Controller
public class SignUpController {

	@Autowired
	private UsuarioServiceImpl serviceUsuario;
	
	private static HashMap<String, String> erros;
	
	public SignUpController() {
		erros = new HashMap<String, String>();
		erros.put("erro1" , "O nome de login está vazio");
		erros.put("erro2" , "Este nome de login já existe");
		erros.put("erro3" , "Campo de senha está vazio");
		erros.put("erro4" , "Os campos de senha estão diferentes");
	}
	
	private Usuario MapSignUpUsuario(SignUp signup) {
		Usuario usuario = new Usuario();
		usuario.setUsername(signup.getUsername());
		usuario.setPassword(signup.getPassword());
		usuario.setActive(true);
		return usuario;
	}
	
	@GetMapping({"/novaconta"})
	@PostMapping({"/novaconta"})
	public String getNovaConta(ModelMap model) {
		return "novaconta";
	}
	
	@PostMapping({"/auditar-novaconta"})
	public ModelAndView postNovaConta(SignUp signup) {
		ModelAndView mvNovaConta = new ModelAndView("novaconta").addObject("tituloErro","Erro em cadastro!");
		if (signup.getUsername().isBlank()) { //usuario vazio
			return mvNovaConta.addObject("alerta", erros.get("erro1"));
		}
		if (signup.getPassword().isBlank()) { //password vazia
			return mvNovaConta.addObject("alerta", erros.get("erro3"));
		}
		if (!signup.getPassword().equals(signup.getRepeatPassword())) { //password não confere com a verificação
			System.out.println(signup.getPassword() + signup.getRepeatPassword());
			return mvNovaConta.addObject("alerta", erros.get("erro4"));
		}
		if (!serviceUsuario.buscarAtivosPorUsername(signup.getUsername()).isEmpty()) { //usuario já existe
			System.out.println(serviceUsuario.buscarAtivosPorUsername(signup.getUsername()));
			return mvNovaConta.addObject("alerta", erros.get("erro2"));
		}
		
		signup.setPassword(new BCryptPasswordEncoder().encode(signup.getPassword()));
		serviceUsuario.salvar(MapSignUpUsuario(signup));
		return new ModelAndView("sucesso");
	}
	
	@PostMapping({"/sucesso"})
	public String sucesso() {
		return "sucesso";
	}
}
