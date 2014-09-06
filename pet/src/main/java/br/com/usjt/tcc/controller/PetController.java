package br.com.usjt.tcc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.usjt.tcc.interfaces.dao.ColorDao;
import br.com.usjt.tcc.interfaces.dao.NGODao;
import br.com.usjt.tcc.interfaces.dao.PetDao;
import br.com.usjt.tcc.interfaces.dao.RaceDao;
import br.com.usjt.tcc.interfaces.dao.TypeDao;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.Color;
import br.com.usjt.tcc.model.NGO;
import br.com.usjt.tcc.model.Pet;
import br.com.usjt.tcc.model.Race;
import br.com.usjt.tcc.model.Type;
import br.com.usjt.tcc.model.User;

@Controller
public class PetController {

	@Autowired
	PetDao petDao;

	@Autowired
	UserDao userDao;

	@Autowired
	TypeDao typeDao;

	@Autowired
	RaceDao raceDao;

	@Autowired
	ColorDao colorDao;

	@Autowired
	NGODao ngoDao;

	@RequestMapping("novoAnimal")
	public String novoAnimal(Model model) {

		List<Type> types = typeDao.lista();
		model.addAttribute("types", types);

		List<Race> races = raceDao.lista();
		model.addAttribute("races", races);

		List<Color> colors = colorDao.lista();
		model.addAttribute("colors", colors);

		return "/pet/register";
	}

	@RequestMapping("listPets")
	public String listPet(Model model, HttpSession session) {

		User loggedUser = (User) session.getAttribute("loggedUser");
		model.addAttribute("loggedUser", loggedUser);

		List<Pet> pets = null;

		NGO ngo = (NGO) session.getAttribute("loggedNGO");
		if (ngo == null) {
			pets = loggedUser.getPets();
		} else {
			pets = ngo.getPets();
		}

		model.addAttribute("pets", pets);

		List<Type> types = typeDao.lista();
		model.addAttribute("types", types);

		List<Race> races = raceDao.lista();
		model.addAttribute("races", races);

		List<Color> colors = colorDao.lista();
		model.addAttribute("colors", colors);

		return "/pet/list";
	}

	@RequestMapping("registerPet")
	public String registerPet(Pet pet, HttpServletRequest request,
			HttpSession session) {

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		try {
			pet.setFoto(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		pet.setType(typeDao.busca(pet.getType().getId()));
		pet.setRace(raceDao.busca(pet.getRace().getId()));
		pet.setColor(colorDao.busca(pet.getColor().getId()));
		pet.setIsActive(true);

		NGO ngo = (NGO) session.getAttribute("loggedNGO");
		if (ngo == null) {
			User loggedUser = (User) session.getAttribute("loggedUser");
			pet.setUser(loggedUser);
			petDao.adiciona(pet);
			loggedUser.getPets().add(pet);
		} else {
			pet.setNgo(ngo);
			petDao.adiciona(pet);
			ngo.getPets().add(pet);
		}

		return "redirect:/listPets";
	}

	@RequestMapping("updatePet")
	public String editPet(Pet pet, HttpSession session,
			HttpServletRequest request) {

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		try {
			pet.setFoto(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		NGO ngo = (NGO) session.getAttribute("loggedNGO");
		if (ngo == null) {
			User user = (User) session.getAttribute("loggedUser");
			pet.setUser(user);
			petDao.atualiza(pet);

			for (int i = 0; i < user.getPets().size(); i++) {
				if (user.getPets().get(i).getId() == pet.getId())
					user.getPets().set(i, pet);
			}

		} else {
			pet.setNgo(ngo);
			petDao.atualiza(pet);

			for (int i = 0; i < ngo.getPets().size(); i++) {
				if (ngo.getPets().get(i).getId() == pet.getId())
					ngo.getPets().set(i, pet);
			}
		}
		return "redirect:/listPets";
	}

	@RequestMapping("deletePet")
	public String deletePet(Model model, HttpSession session) {

		System.out.println("DeletePet");

		return "/pet/list";
	}

}
