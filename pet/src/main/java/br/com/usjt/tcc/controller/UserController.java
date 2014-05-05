package br.com.usjt.tcc.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.usjt.tc.helper.HashHelper;
import br.com.usjt.tcc.dao.UserDao;
import br.com.usjt.tcc.model.Address;
import br.com.usjt.tcc.model.User;

@Controller
public class UserController {

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

		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("tcc-mysql");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		UserDao userDao = new UserDao(entityManager);

		userDao.adiciona(user);

		entityManager.close();

		return "user/login";
	}
}
