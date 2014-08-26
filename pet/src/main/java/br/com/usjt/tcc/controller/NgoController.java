package br.com.usjt.tcc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.usjt.tcc.helper.HashHelper;
import br.com.usjt.tcc.interfaces.dao.NGODao;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.NGO;
import br.com.usjt.tcc.model.RegisterNest;
import br.com.usjt.tcc.model.User;

@Controller
public class NgoController {
	
	@Autowired
	private NGODao ngoDao;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("registerNGO")
	public String registerNGO(RegisterNest registerNest, HttpServletRequest request) {
		
		String retorno = null;
		NGO ngo = new NGO();
		User user = registerNest.getUser();
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile file =  multipartRequest.getFile("file");
			user.setFoto(file.getBytes());
			user.setPassword(HashHelper.sha256(user.getPassword()));
			user.setCellphone(user.getCellphone().replaceAll("\\D", ""));  
			user.setPhone(user.getPhone().replaceAll("\\D", ""));
			ngo.setName(registerNest.getCompany().getName());
			ngo.setCnpj(registerNest.getCompany().getCnpj());
			ngo.setSite(registerNest.getCompany().getSite());
			user.setIsOfNGO(true);
			ngo.setAdministrator(registerNest.getUser());
			
			if(userDao.buscaUserEmail(user.getEmail())){
				request.setAttribute("existeUser", true);
				retorno = "user/register";
			}else{
				ngoDao.adiciona(ngo);
				retorno = "user/login";
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return retorno;
	}
	
}
