package br.com.usjt.tcc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.usjt.tcc.interfaces.dao.AlertDao;
import br.com.usjt.tcc.interfaces.dao.NGODao;
import br.com.usjt.tcc.interfaces.dao.PetDao;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.interfaces.dao.VoucherDao;
import br.com.usjt.tcc.model.Alert;
import br.com.usjt.tcc.model.NGO;
import br.com.usjt.tcc.model.Pet;
import br.com.usjt.tcc.model.User;
import br.com.usjt.tcc.model.Voucher;

@Controller
public class AdoptionController {

	@Autowired
	NGODao ngoDao;

	@Autowired
	VoucherDao voucherDao;

	@Autowired
	PetDao petDao;

	@Autowired
	AlertDao alertDao;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("petsForAdoption")
	public String listPet(Model model, HttpSession session) {

		User loggedUser = (User) session.getAttribute("loggedUser");
		model.addAttribute("loggedUser", loggedUser);

		List<NGO> ngos = ngoDao.lista();
		model.addAttribute("ngos", ngos);

		return "/adoption/list";
	}

	@RequestMapping("adoptionPet")
	public String adoptionPet(Model model, HttpSession session,
			Long id_voucher, Long id_alert, Boolean opcao) {

		Voucher voucher = voucherDao.busca(id_voucher);
		
		if (opcao) {
			Pet pet = voucher.getPet();
			User user = voucher.getUser();
			pet.setUser(user);
			pet.setNgo(null);
			
			petDao.atualiza(pet);
			
			user.setScore(user.getScore()+500);
			userDao.atualiza(user);

		}

		Alert alert = alertDao.busca(id_alert);
		alert.setIsActive(false);
		alertDao.atualiza(alert);
		
		 NGO ngo = ngoDao.busca(voucher.getNgo().getId());
		 session.setAttribute("loggedNGO", ngo);
		

		return "/menu/initPage";
	}
	
	@RequestMapping("apadrinhaPet")
	public String apadrinhaPet(Model model, HttpSession session,
			Long id_voucher, Long id_alert, Boolean opcao) {

		Voucher voucher = voucherDao.busca(id_voucher);
		
		if (opcao) {
			
			User user = voucher.getUser();
			user.setScore(user.getScore()+400);
			userDao.atualiza(user);

		}

		Alert alert = alertDao.busca(id_alert);
		alert.setIsActive(false);
		alertDao.atualiza(alert);
		
		 NGO ngo = ngoDao.busca(voucher.getNgo().getId());
		 session.setAttribute("loggedNGO", ngo);
		

		return "/menu/initPage";
	}
	
	@RequestMapping("donate")
	public String donate(Model model, HttpSession session,
			Long id_voucher, Long id_alert, Boolean opcao) {

		Voucher voucher = voucherDao.busca(id_voucher);
		
		if (opcao) {
			
			User user = voucher.getUser();
			user.setScore(user.getScore()+200);
			userDao.atualiza(user);

		}

		Alert alert = alertDao.busca(id_alert);
		alert.setIsActive(false);
		alertDao.atualiza(alert);
		
		 NGO ngo = ngoDao.busca(voucher.getNgo().getId());
		 session.setAttribute("loggedNGO", ngo);
		

		return "/menu/initPage";
	}
}
