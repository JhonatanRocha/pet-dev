package br.com.usjt.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.usjt.tcc.interfaces.dao.OwnerDao;
import br.com.usjt.tcc.model.Owner;
import br.com.usjt.tcc.model.User;

@Controller
public class OwnerController {

	@Autowired
	private OwnerDao ownerDao;
	
	@RequestMapping("registerOwner")
	public String registerUser(User user) {
		
		Owner owner = new Owner(); 
		owner.setUser(user);
		ownerDao.adiciona(owner);
		return "/user/login";
	}
	
	
}
