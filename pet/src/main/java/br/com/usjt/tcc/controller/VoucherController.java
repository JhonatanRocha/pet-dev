package br.com.usjt.tcc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.usjt.tcc.interfaces.dao.NGODao;
import br.com.usjt.tcc.interfaces.dao.PetDao;
import br.com.usjt.tcc.interfaces.dao.PetShopDao;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.interfaces.dao.VoucherDao;
import br.com.usjt.tcc.model.NGO;
import br.com.usjt.tcc.model.Pet;
import br.com.usjt.tcc.model.User;
import br.com.usjt.tcc.model.Voucher;

@Controller
public class VoucherController {

	@Autowired
	UserDao userDao;

	@Autowired
	NGODao ngoDao;

	@Autowired
	PetShopDao petShopDao;

	@Autowired
	VoucherDao voucherDao;

	@Autowired
	PetDao petDao;

	@RequestMapping("newVoucher/{id}")
	public String newVoucher(Model model, HttpServletResponse response,
			@PathVariable("id") final Long id) {

		model.addAttribute("id_animal", id);
		return "/voucher/new";
	}

	@RequestMapping("newVoucher/generateVoucherAnimal")
	public String generateVoucherAnimal(Model model, HttpSession session,
			HttpServletResponse response, Long id, Integer tipo) {

		User loggedUser = (User) session.getAttribute("loggedUser");
		model.addAttribute("loggedUser", loggedUser);

		Long voucherNumber = geraVoucherRandomico(loggedUser.getId());

		Pet pet = petDao.busca(id);
		NGO ngo = pet.getNgo();

		Voucher voucher = new Voucher();
		voucher.setTipo(tipo);
		voucher.setNgo(ngo);
		voucher.setPet(pet);
		voucher.setNumber(voucherNumber);
		voucher.setUser(loggedUser);

		voucherDao.adiciona(voucher);

		model.addAttribute("voucher", voucher);

		return "voucher/voucher";
	}

	private Long geraVoucherRandomico(Long id) {
		Long i = new Date().getTime();

		Double random = Math.random()*id;
		
		String vous = ("" + random).replace(".", "").replace(",", "");
		
		i = i + Long.parseLong(vous);

		return i;
	}

}
