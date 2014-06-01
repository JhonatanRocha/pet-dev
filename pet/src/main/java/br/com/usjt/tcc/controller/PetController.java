package br.com.usjt.tcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PetController {

	@RequestMapping("novoAnimal")
	public String novoAnimal() {
		return "/pet/register";
	}

}
