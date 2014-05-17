package br.com.usjt.tcc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.usjt.tcc.helper.HashHelper;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.User;

@Controller
public class LoginController {
	
	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/efetuaLogin", method = {RequestMethod.GET})
	public String efetuaLogin(User user, HttpSession session) {

		user.setPassword(HashHelper.sha256(user.getPassword()));

		if (userDao.existeUser(user)) {
			session.setAttribute("usuarioLogado", user);
			return "/menu/initPage";
		}
		return "redirect:novoUsuario";
	}

}
