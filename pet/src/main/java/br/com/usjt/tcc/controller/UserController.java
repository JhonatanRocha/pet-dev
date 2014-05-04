package br.com.usjt.tcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {

	@RequestMapping("novoUsuario")
	public String joinUs(){
		return "/user/register";
	}
	
	@RequestMapping("")
	public String main(){
		return "/user/login";
	}
	
	@RequestMapping("preCadastro")
	public String preRegister(String email, String password, Model model){
		
		model.addAttribute(email);
		model.addAttribute(password);
		
		return "redirect:novoUsuario";
	}
}
