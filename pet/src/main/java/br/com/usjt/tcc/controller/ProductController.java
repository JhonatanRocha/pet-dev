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
import br.com.usjt.tcc.model.PetShop;
import br.com.usjt.tcc.model.Product;
import br.com.usjt.tcc.model.User;

@Controller
public class ProductController {

	@Autowired
	private ProductDao productDao;

	@Autowired
	private PetShopDao petShopDao;

	@RequestMapping(value = "products", method = RequestMethod.GET)
	public String listProduct(Model model, HttpSession session) {

		User loggedUser = (User) session.getAttribute("loggedUser");
		model.addAttribute("loggedUser", loggedUser);

		PetShop petShop = petShopDao.busca(loggedUser);

		if (petShop != null) {
			List<Product> products = petShop.getProducts();
			model.addAttribute("products", products);
		}
		return "/product/list";

	}

	@RequestMapping("registerProducts")
	public void registerProduct(Product product) {

		productDao.adiciona(product);

	}

}
