package br.com.usjt.tcc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.usjt.tcc.interfaces.dao.PetShopDao;
import br.com.usjt.tcc.interfaces.dao.ProductDao;
import br.com.usjt.tcc.interfaces.dao.RaceDao;
import br.com.usjt.tcc.interfaces.dao.RuleDao;
import br.com.usjt.tcc.interfaces.dao.TypeDao;
import br.com.usjt.tcc.model.PetShop;
import br.com.usjt.tcc.model.Product;
import br.com.usjt.tcc.model.Race;
import br.com.usjt.tcc.model.Rule;
import br.com.usjt.tcc.model.Type;
import br.com.usjt.tcc.model.User;

@Controller
public class ProductController {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private PetShopDao petShopDao;

	@Autowired
	TypeDao typeDao;
	
	@Autowired
	RaceDao raceDao;
	
	@Autowired
	RuleDao ruleDao;
	
	
	@RequestMapping(value = "products", method = RequestMethod.GET)
	public String listProduct(Model model, HttpSession session) {

		User loggedUser = (User) session.getAttribute("loggedUser");
		model.addAttribute("loggedUser", loggedUser);

		PetShop petShop = petShopDao.busca(loggedUser);

		if (petShop != null) {
			List<Product> products = petShop.getProducts();
			model.addAttribute("products", products);
		}
		
		
		List<Type> types = typeDao.lista();
		model.addAttribute("types", types);
		
		List<Race> races = raceDao.lista();
		model.addAttribute("races", races);
		
		
		return "/product/list";

	}

	@RequestMapping("newProducts")
	public String newProduct(Model model) {
		
		List<Type> types = typeDao.lista();
		model.addAttribute("types", types);
		
		List<Race> races = raceDao.lista();
		model.addAttribute("races", races);
		
		return "/product/register";
	}
	
	
	@RequestMapping("registerProducts")
	public String registerProduct(Product product, HttpSession session) {
		
		User loggedUser = (User) session.getAttribute("loggedUser");

		PetShop petShop = petShopDao.busca(loggedUser);

		if (petShop != null) {
			product.setPetShop(petShop);
		}
		
		productDao.adiciona(product);
		
		Rule rule = new Rule();
		rule.setProduct(product);
		rule.setRace(false);
		rule.setScore(false);
		rule.setSize(false);
		rule.setStage(false);
		rule.setType(false);
		
		ruleDao.adiciona(rule);
		
		return "redirect:/products";
	}
	
	@RequestMapping("updatePet")
	public String updateProduct(Product product , HttpSession session) {
		
		User loggedUser = (User) session.getAttribute("loggedUser");

		PetShop petShop = petShopDao.busca(loggedUser);

		if (petShop != null) {
			product.setPetShop(petShop);
		}
		
		productDao.atualiza(product);
		
		return "redirect:/products";
	}
	
}
