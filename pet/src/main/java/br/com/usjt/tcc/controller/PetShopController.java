package br.com.usjt.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.usjt.tcc.interfaces.dao.PetShopDao;
import br.com.usjt.tcc.model.PetShop;
import br.com.usjt.tcc.model.RegisterNest;

@Controller
public class PetShopController {

	@Autowired
	private PetShopDao petShopDao;

	@RequestMapping("registerPetShop")
	public String registerPetShop(RegisterNest registerNest) {

		PetShop petShop = new PetShop();
		petShop.setName(registerNest.getCompany().getName());
		petShop.setCnpj(registerNest.getCompany().getCnpj());
		petShop.setSite(registerNest.getCompany().getSite());
		petShop.setAdministrator(registerNest.getUser());

		petShopDao.adiciona(petShop);

		return "/user/login";
	}

	@RequestMapping("novoProduto")
	public String novoProduto() {
		return "/product/register";
	}

}
