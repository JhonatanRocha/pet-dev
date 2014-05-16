package br.com.usjt.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.usjt.tcc.interfaces.dao.NGODao;
import br.com.usjt.tcc.model.NGO;
import br.com.usjt.tcc.model.RegisterNest;

@Controller
public class NgoController {
	
	@Autowired
	private NGODao ngoDao;
	
	@RequestMapping("registerNGO")
	public String registerNGO(RegisterNest registerNest) {
				
		NGO ngo = new NGO();
		ngo.setName(registerNest.getCompany().getName());
		ngo.setCnpj(registerNest.getCompany().getCnpj());
		ngo.setSite(registerNest.getCompany().getSite());
		ngo.setAdministrator(registerNest.getUser());
		ngoDao.adiciona(ngo);
		
		return "/user/login";
	}
	
}
