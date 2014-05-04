package br.com.usjt.tcc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestsController {

	@RequestMapping("test")
	public String test(){
		return "/main/main";
	}
}
