package br.com.usjt.tcc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.usjt.tcc.helper.HashHelper;
import br.com.usjt.tcc.interfaces.dao.PetShopDao;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.PetShop;
import br.com.usjt.tcc.model.RegisterNest;
import br.com.usjt.tcc.model.User;

@Controller
public class PetShopController {

	@Autowired
	private PetShopDao petShopDao;

	@Autowired
	UserDao userDao;

	@RequestMapping("registerPetShop")
	public String registerPetShop(RegisterNest registerNest, HttpServletRequest request) {

		String retorno = "";
		PetShop petShop = new PetShop();
		User user = registerNest.getUser();
		
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = multipartRequest.getFile("file");
			user.setFoto(file.getBytes());
			user.setPassword(HashHelper.sha256(user.getPassword()));
			user.setCellphone(user.getCellphone().replaceAll("\\D", ""));  
			user.setPhone(user.getPhone().replaceAll("\\D", ""));
			user.setIsOfPetShop(true);
			
			petShop.setName(registerNest.getCompany().getName());
			petShop.setCnpj(registerNest.getCompany().getCnpj().replace(".", "").replace("/", "").replace("-", "").trim());
			petShop.setSite(registerNest.getCompany().getSite());
			petShop.setAdministrator(registerNest.getUser());
			
			if(userDao.buscaUserEmail(user.getEmail())){
				request.setAttribute("existeUser", true);
				retorno = "user/register";
			}else{
				petShopDao.adiciona(petShop);
				retorno = "user/login";
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retorno;
	}

	@RequestMapping("novoProduto")
	public String novoProduto() {
		return "/product/register";
	}

}
