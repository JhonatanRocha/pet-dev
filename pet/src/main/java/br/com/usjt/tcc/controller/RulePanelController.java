package br.com.usjt.tcc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.usjt.tcc.interfaces.dao.PetShopDao;
import br.com.usjt.tcc.interfaces.dao.ProductDao;
import br.com.usjt.tcc.interfaces.dao.RuleDao;
import br.com.usjt.tcc.model.PetShop;
import br.com.usjt.tcc.model.Product;
import br.com.usjt.tcc.model.Rule;
import br.com.usjt.tcc.model.User;

@Controller
public class RulePanelController {
	
	@Autowired
	private RuleDao ruleDao;
	
	@Autowired
	private ProductDao productDao;

	@Autowired
	private PetShopDao petShopDao;

	
	@RequestMapping("regras")
	public String registerNGO(Model model, HttpSession session) {
		
		User loggedUser = (User) session.getAttribute("loggedUser");
		PetShop petShop = petShopDao.busca(loggedUser);
		
		List<Rule> rules = ruleDao.lista(petShop);
		
		model.addAttribute("rules", rules);
	
		return "/rule/panel";
	}
	
	
	
	@RequestMapping("updateRule")
	public String updateRule(Rule rule){
		
		if(rule.getType() == null)
			rule.setType(false);
		
		if(rule.getRace() == null)
			rule.setRace(false);

		if(rule.getStage() == null)
			rule.setStage(false);
				
		if(rule.getSize() == null)
			rule.setSize(false);
		
		if(rule.getScore() == null)
			rule.setScore(false);
		
		
		Product product = productDao.busca(rule.getProduct().getId());
		rule.setProduct(product);
		
		ruleDao.atualiza(rule);
		
		return "redirect:/regras";
	}
	
	
	
	@RequestMapping("inserirRegra")
	public String registerNGO(Rule rule) {
		return "/user/rulePanel";
	}	
	
	
}
