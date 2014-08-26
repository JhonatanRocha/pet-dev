package br.com.usjt.tcc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.usjt.tcc.helper.HashHelper;
import br.com.usjt.tcc.interfaces.dao.UserDao;
import br.com.usjt.tcc.model.RegisterNest;
import br.com.usjt.tcc.model.User;

@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("")
	public String main() {
		return "/user/login";
	}

	@RequestMapping("novoUsuario")
	public String preRegister(User user, Model model) {
		
		model.addAttribute("email", user.getEmail());
		model.addAttribute("password", user.getPassword());
		
		return "/user/register";
	}

	@RequestMapping("registerUser")
	public String registerUser(RegisterNest registerNest, HttpServletRequest request) {
		String retorno = null;
		
		User user = populatedUser(registerNest, request, false);
		
		if(userDao.buscaUserEmail(user.getEmail())){
			request.setAttribute("existeUser", true);
			retorno = "user/register";
		}else{
			userDao.adiciona(user);
			retorno = "user/login";
		}
		
		return retorno;
	}
	
	@RequestMapping("editarUsuario")
	public String editUser() {
		
		return "/user/editUser";
	}
	
	@RequestMapping("alterUser")
	public String alterUser(RegisterNest registerNest, HttpSession session, HttpServletRequest request) {
		
		User userLogged = (User) session.getAttribute("loggedUser");
		boolean isFoto = false;
		
		if(registerNest.getUser().getFoto() == null){
			registerNest.getUser().setFoto(userLogged.getFoto());
			isFoto = true;
		}
		
		User user = populatedUser(registerNest, request, isFoto);
		
		user.setId(userLogged.getId());
		userDao.atualiza(user);
		
		session.setAttribute("loggedUser", user);
		
		return "/menu/initPage";
	}
	
	@RequestMapping("deactivateUser")
	public String deactivateUser(RegisterNest registerNest, HttpServletRequest request) {
		userDao.atualiza(registerNest.getUser());
		return "/menu/initPage";
	}
	
	private User populatedUser(RegisterNest registerNest, HttpServletRequest request, boolean isFoto){
		
		User user = registerNest.getUser();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file =  multipartRequest.getFile("file");
        
        try {
			user.setFoto(file.getBytes());
			user.setPassword(HashHelper.sha256(user.getPassword()));
			user.setCellphone(user.getCellphone().replaceAll("\\D", ""));  
			user.setPhone(user.getPhone().replaceAll("\\D", ""));
        } catch (IOException e) {
			e.printStackTrace();
		}
        
		return user;
	}
	
}
