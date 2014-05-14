package br.com.usjt.tcc.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.usjt.tcc.helper.HashHelper;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.Address;
import br.com.usjt.tcc.model.Company;
import br.com.usjt.tcc.model.User;

@Controller
public class UserController {

	
	@Autowired
	UserDao userDao;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@RequestMapping("")
	public String main() {
		return "/user/login";
	}

	@RequestMapping("novoUsuario")
	public String preRegister(User user, Model model) {

		model.addAttribute("email", user.getEmail());
		model.addAttribute("password", user.getPassword());
		model.addAttribute("isOwner", user.getIsOwner());
		model.addAttribute("isOfNGO", user.getIsOfNGO());
		model.addAttribute("isOfPetShop", user.getIsOfPetShop());

		return "/user/register";
	}

	@RequestMapping("registerUser")
	public String registerUser(@ModelAttribute("user")User user, @ModelAttribute("company")Company company, Address address,final RedirectAttributes redirectAttributes) {
		user.setAddress(address);
		user.setPassword(HashHelper.sha256(user.getPassword()));
		user.setCellphone(user.getCellphone().replaceAll("\\D", ""));  
		user.setPhone(user.getPhone().replaceAll("\\D", ""));
		
		userDao.adiciona(user);
		
		//Só para trazer o user de volta pro estado Managed com o id cadastrado
		user =  userDao.buscaPeloEmail(user.getEmail());
		
		redirectAttributes.addFlashAttribute("user", user);
		if(user.getIsOwner()){
			return "redirect:registerOwner";
		}else if(user.getIsOfNGO()){
			return "redirect:registerNGO";
		}else if(user.getIsOfPetShop()){
			return "redirect:registerPetShop";
		}
		
		return "user/login";
	}
	
}
