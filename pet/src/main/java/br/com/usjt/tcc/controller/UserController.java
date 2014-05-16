package br.com.usjt.tcc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.usjt.tcc.helper.HashHelper;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.RegisterNest;
import br.com.usjt.tcc.model.User;

@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("")
	public String main() {
		return "/user/login";
	}

	@RequestMapping("novoUsuario")
	public String preRegister(User user, Model model) {
		
		model.addAttribute("email", user.getEmail());
		model.addAttribute("password", user.getPassword());
		
		return "/user/register";
	}

	@RequestMapping("registerUser")
	public String registerUser(RegisterNest registerNest) {
		User user = registerNest.getUser();
		user.setPassword(HashHelper.sha256(user.getPassword()));
		user.setCellphone(user.getCellphone().replaceAll("\\D", ""));  
		user.setPhone(user.getPhone().replaceAll("\\D", ""));
		
		userDao.adiciona(user);
	
		return "user/login";
	}
}
