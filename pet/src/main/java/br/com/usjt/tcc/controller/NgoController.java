package br.com.usjt.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.usjt.tcc.interfaces.dao.NGODao;
import br.com.usjt.tcc.model.NGO;
import br.com.usjt.tcc.model.User;

@Controller
public class NgoController {
	
	@Autowired
	private NGODao ngoDao;
	
	@RequestMapping("registerNGO")
	public String registerNGO(User user) {
		
		NGO ngo = new NGO();  
		ngo.setAdministrator(user);
		ngoDao.adiciona(ngo);
		return "/user/login";
	}
	
}
