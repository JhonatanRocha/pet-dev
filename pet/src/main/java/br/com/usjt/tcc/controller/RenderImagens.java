package br.com.usjt.tcc.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.usjt.tcc.interfaces.dao.PetDao;
import br.com.usjt.tcc.interfaces.dao.UserDao;

@Controller
public class RenderImagens {

	@Autowired
	PetDao petDao;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/getImagePet/{id}")
	public void getImagePet(HttpServletResponse response,@PathVariable("id") final Long id) throws IOException {
		response.setContentType("image/jpeg");
	    byte[] imageBytes = petDao.busca(id).getFoto();
	    response.getOutputStream().write(imageBytes);
	    response.getOutputStream().flush();
	}
	
	@RequestMapping("/getImageUser/{id}")
	public void getImageUser(HttpServletResponse response,@PathVariable("id") final Long id) throws IOException {
		response.setContentType("image/jpeg");
	    byte[] imageBytes = userDao.busca(id).getFoto();
	    response.getOutputStream().write(imageBytes);
	    response.getOutputStream().flush();
	}



}
