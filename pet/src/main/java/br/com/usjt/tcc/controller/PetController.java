package br.com.usjt.tcc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.usjt.tcc.interfaces.dao.ColorDao;
import br.com.usjt.tcc.interfaces.dao.PetDao;
import br.com.usjt.tcc.interfaces.dao.RaceDao;
import br.com.usjt.tcc.interfaces.dao.TypeDao;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.Color;
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
		
		User loggedUser = (User)session.getAttribute("loggedUser");
		model.addAttribute("loggedUser", loggedUser);
		
//		List<Pet> pets = loggedUser.getPets();
//		
//		Pet as = pets.get(0);
//		model.addAttribute("pets", pets);
//				
		return "/pet/list";
	}
	
	
	@RequestMapping("registerPet")
	public String registerPet(Pet pet, HttpServletRequest request, HttpSession session) {
		
		System.out.println("registerPEt");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file =  multipartRequest.getFile("file");
        try {
			pet.setFoto(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        pet.setType(typeDao.busca(pet.getType().getId()));
        pet.setRace(raceDao.busca(pet.getRace().getId()));
        pet.setColor(colorDao.busca(pet.getColor().getId()));
        
		petDao.adiciona(pet);
		pet = petDao.busca(pet);

        User loggedUser = (User)session.getAttribute("loggedUser");
        
        List<Pet> userPets = loggedUser.getPets();	
        if(!Hibernate.isInitialized(userPets))
        	userPets = new ArrayList<Pet>();
		
        userPets.add(pet);
		
        loggedUser.setPets(userPets);
		userDao.atualiza(loggedUser);
		
		return "/menu/initPage";
	}
	
}
