package br.com.usjt.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.usjt.tcc.interfaces.dao.PetShopDao;
import br.com.usjt.tcc.model.PetShop;
import br.com.usjt.tcc.model.User;

@Controller
public class PetShopController {

	@Autowired
	private PetShopDao petShopDao;

	@RequestMapping("registerPetShop")
	public String registerPetShop(User user) {

		PetShop petShop = new PetShop();
		petShop.setAdministrator(user);

		petShopDao.adiciona(petShop);
		return "/user/login";
	}

}
