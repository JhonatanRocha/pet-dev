package br.com.usjt.tcc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.usjt.tcc.helper.HashHelper;
import br.com.usjt.tcc.interfaces.dao.NGODao;
import br.com.usjt.tcc.interfaces.dao.PetShopDao;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.NGO;
import br.com.usjt.tcc.model.PetShop;
import br.com.usjt.tcc.model.User;

@Controller
public class LoginController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	PetShopDao petShopDao;
	
	@Autowired
	NGODao ngoDao;
	
	@RequestMapping(value = "/efetuaLogin", method = { RequestMethod.POST })
	public String efetuaLogin(User user, HttpSession session) {
		String retorno = "redirect:";
		try {
			user.setPassword(HashHelper.sha256(user.getPassword()));

			if (userDao.existeUser(user)) {
				user = userDao.buscaPeloEmail(user.getEmail());
				retorno = validateActivated(session, user);
				setTypeUser(session, user);
			}else{
				session.setAttribute("erroLogin", true);
				session.setAttribute("erroSistema", false);
			}
		} catch (Exception e) {
			session.setAttribute("erroSistema", true);
			e.printStackTrace();
		}
		return retorno;
	}
	
	private void setTypeUser(HttpSession session, User user) {
		
		if(user.getIsOfNGO()){
			NGO ngo = ngoDao.buscaPeloADM(user.getId());
			session.setAttribute("loggedNGO", ngo);
		}
		
		if(user.getIsOfPetShop()){
			PetShop petShop = petShopDao.buscaUserId(user.getId());
			session.setAttribute("loggedPetShop", petShop);
		}
		
	}

	@RequestMapping(value ="/efetuaLogout")
	public String efetuaLogout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null)
		    session.invalidate();
		
        return "/user/login";
	}
	
	private String validateActivated(HttpSession session, User user){
		if(user.getIsActivated()){
			session.setAttribute("loggedUser", user);
			session.setAttribute("erroLogin", false);
			session.setAttribute("erroSistema", false);
			return "/menu/initPage";
		}else{
			session.setAttribute("erroLogin", true);
			session.setAttribute("erroSistema", false);
		}
		return "redirect:";
	}

}
