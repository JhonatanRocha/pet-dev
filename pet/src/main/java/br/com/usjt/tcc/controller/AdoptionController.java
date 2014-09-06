package br.com.usjt.tcc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.usjt.tcc.interfaces.dao.NGODao;
import br.com.usjt.tcc.model.NGO;
import br.com.usjt.tcc.model.User;

@Controller
public class AdoptionController {

	@Autowired
	NGODao ngoDao;
	
	@RequestMapping("petsForAdoption")
	public String listPet(Model model, HttpSession session) {
		
		User loggedUser = (User)session.getAttribute("loggedUser");
		model.addAttribute("loggedUser", loggedUser);
		
		List<NGO> ngos = ngoDao.lista();
		model.addAttribute("ngos", ngos);
		
		return "/adoption/list";
	}
}
