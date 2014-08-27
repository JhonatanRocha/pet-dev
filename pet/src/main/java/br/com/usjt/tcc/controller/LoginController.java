package br.com.usjt.tcc.controller;

import javax.servlet.http.HttpServletRequest;
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
	
	
	@RequestMapping(value = "/efetuaLogin", method = { RequestMethod.POST })
	public String efetuaLogin(User user, HttpSession session) {
		
		try {
			user.setPassword(HashHelper.sha256(user.getPassword()));

			if (userDao.existeUser(user)) {
				user = userDao.buscaPeloEmail(user.getEmail());
				
				if(user.getIsActivated()){
					session.setAttribute("loggedUser", user);
					session.setAttribute("erroLogin", false);
					session.setAttribute("erroSistema", false);
					return "/menu/initPage";
				}else{
					session.setAttribute("erroLogin", true);
					session.setAttribute("erroSistema", false);
				}
			}else{
				session.setAttribute("erroLogin", true);
				session.setAttribute("erroSistema", false);
			}
		} catch (Exception e) {
			session.setAttribute("erroSistema", true);
			e.printStackTrace();
		}
		return "redirect:";
	}
	
	@RequestMapping(value ="/efetuaLogout")
	public String efetuaLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null)
		    session.invalidate();
		
        return "/user/login";
	}

}
