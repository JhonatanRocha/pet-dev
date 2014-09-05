package br.com.usjt.tcc.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestesController {

	@Autowired
	private UserDaoTeste userDaoTeste;

	@Autowired
	private ColorDaoTeste colorDaoTeste;

	@Autowired
	private NGODaoTeste ngoDaoTeste;

	@Autowired
	private PetDaoTeste petDaoTeste;

	@Autowired
	private RaceDaoTeste raceDaoTeste;

	@Autowired
	private TypeDaoTeste typeDaoTeste;

	@Autowired
	private ProductDaoTeste productDaoTeste;

	@Autowired
	private PetShopDaoTeste petShopDaoTeste;
	
	@Autowired
	private RuleDaoTeste ruleDaoTeste;
	
	@Autowired
	private AnnouncementDaoTeste announcementDaoTeste;

	@RequestMapping("testUserDao")
	public void testUserDao() {
		userDaoTeste.test();
	}

	@RequestMapping("testColorDao")
	public void testColorDao() {
		colorDaoTeste.test();
	}

	@RequestMapping("testNGODao")
	public void testNGODao() {
		ngoDaoTeste.test();
	}

	@RequestMapping("testPetDao")
	public void testPetDao() {
		petDaoTeste.test();
	}

	@RequestMapping("testRaceDao")
	public void testRaceDao() {
		raceDaoTeste.test();
	}

	@RequestMapping("testTypeDao")
	public void testTypeDao() {
		typeDaoTeste.test();
	}

	@RequestMapping("testPetShopDao")
	public void testPetShopDao() {
		petShopDaoTeste.test();
	}

	@RequestMapping("testProductDao")
	public void testProductDao() {
		productDaoTeste.test();
	}

	@RequestMapping("testRuleDao")
	public void testRuleDao() {
		ruleDaoTeste.test();
	}
	
	
	@RequestMapping("testAnnouncementDao")
	public void testAnnouncementDao() {
		announcementDaoTeste.test();
	}
	
	@RequestMapping("testAllDaos")
	public void testAllDaos() {
		colorDaoTeste.test();
		raceDaoTeste.test();
		typeDaoTeste.test();
		petDaoTeste.test();
		userDaoTeste.test();
		productDaoTeste.test();
		petShopDaoTeste.test();
		ngoDaoTeste.test();
		ruleDaoTeste.test();
		announcementDaoTeste.test();
	}

}
