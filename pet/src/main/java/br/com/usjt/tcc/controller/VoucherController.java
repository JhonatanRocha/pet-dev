package br.com.usjt.tcc.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.usjt.tcc.interfaces.dao.AlertDao;
import br.com.usjt.tcc.interfaces.dao.NGODao;
import br.com.usjt.tcc.interfaces.dao.PetDao;
import br.com.usjt.tcc.interfaces.dao.PetShopDao;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.interfaces.dao.VoucherDao;
import br.com.usjt.tcc.model.Alert;
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

	@Autowired
	AlertDao alertDao;

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
		voucher.setUsado(1);
		voucher.setNumber(voucherNumber);
		voucher.setUser(loggedUser);

		voucherDao.adiciona(voucher);

		voucher = voucherDao.buscaPeloNumber(voucherNumber);

		Alert alert = new Alert();
		alert.setIsActive(true);
		alert.setNgo(ngo);
		alert.setVoucher(voucher);
		alertDao.adiciona(alert);

		model.addAttribute("voucher", voucher);

		return "voucher/voucher";
	}

	@RequestMapping("getVoucherAnimal")
	public String getVoucherAnimal(Model model, HttpSession session,
			HttpServletResponse response, Long id) {

		Voucher voucher = voucherDao.busca(id);
		model.addAttribute("voucher", voucher);

		return "voucher/voucher";
	}

	@RequestMapping("sendVoucherAnimal")
	public String sendVoucherAnimal(Model model, HttpSession session,
			HttpServletResponse response, Long id) {

		Voucher voucher = voucherDao.busca(id);

		voucher.setUsado(voucher.getUsado()+1);
		voucherDao.atualiza(voucher);
		
		Alert alert = new Alert();
		alert.setIsActive(true);
		alert.setNgo(voucher.getNgo());
		alert.setVoucher(voucher);
		alertDao.adiciona(alert);

		User loggedUser = (User) session.getAttribute("loggedUser");
		
		loggedUser = userDao.busca(loggedUser.getId());
		
		model.addAttribute("loggedUser", loggedUser);

		List<Voucher> vouchers = loggedUser.getVouchers();
		model.addAttribute("vouchers", vouchers);

		return "/voucher/list";
	}

	@RequestMapping("listVouchers")
	public String listVoucher(Model model, HttpSession session) {

		User loggedUser = (User) session.getAttribute("loggedUser");
		model.addAttribute("loggedUser", loggedUser);

		List<Voucher> vouchers = loggedUser.getVouchers();

		model.addAttribute("vouchers", vouchers);

		return "/voucher/list";
	}

	private Long geraVoucherRandomico(Long id) {
		Long i = new Date().getTime();

		Double random = Math.random() * id;

		String vous = ("" + random).replace(".", "").replace(",", "");

		i = i + Long.parseLong(vous);

		return i;
	}

}
