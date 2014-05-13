package br.com.usjt.tcc.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.usjt.tcc.helper.HashHelper;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.Address;
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
	public String preRegister(String email, String password, Model model) {

		model.addAttribute("email", email);
		model.addAttribute("password", password);

		return "/user/register";
	}

	@RequestMapping("registerUser")
	public String registerUser(User user, Address address) {
		user.setAddress(address);
		user.setPassword(HashHelper.sha256(user.getPassword()));
		user.setCellphone(user.getCellphone().replaceAll("\\D", ""));  
		user.setPhone(user.getPhone().replaceAll("\\D", ""));
		
		userDao.adiciona(user);

		return "user/login";
	}
	
}
